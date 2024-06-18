package com.test.test.cuenta;

import com.test.test.cliente.cliente;
import com.test.test.cliente.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class cuentaService {
    @Autowired
    private cuentaRepository cuentaRepository;

    @Autowired
    private cuentaMapper cuentaMapper;

    @Autowired
    private clienteRepository clienteRepository;

    public List<cuentaDTO> getAll() {
        List<cuenta> cuenta = cuentaRepository.findAll();
        return cuenta
                .stream()
                .map(cuentaMapper::cuentaToDTO)
                .collect(Collectors.toList());
    }

    public cuentaDTO create(cuentaDTO cuentaDTO) {

        cliente cliente = null;
        Optional<cliente> clienteByUuid = clienteRepository.findByUuid(cuentaDTO.getCliente());
        if (clienteByUuid.isPresent()) {
            cliente = clienteByUuid.get();
        }
        cuenta cuenta = cuentaMapper.cuentaToModel(cuentaDTO);
        cuenta.setCliente(cliente);
        cuenta cuentaSaved = cuentaRepository.save(cuenta);
        return cuentaMapper.cuentaToDTO(cuentaSaved);
    }

    public cuentaDTO getOne(UUID uuid) {
        Optional<cuenta> optionalCliente = cuentaRepository.findByUuid(uuid);
        cuentaDTO cuentaDTO = cuentaMapper.cuentaToDTO(optionalCliente.get());
        return cuentaDTO;

    }
    public List<cuentaDTO> getByClienteUUID(UUID uuid) {
        cliente cliente = clienteRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));;
        List<cuenta> cuentas = cuentaRepository.findByCliente(cliente);
        return cuentas
                .stream()
                .map(cuentaMapper::cuentaToDTO)
                .collect(Collectors.toList());
    }
    public cuentaDTO edit(cuentaDTO dto) {
        Optional<cuenta> cuentaOptional = cuentaRepository.findByUuid(dto.getUuid());
        cuenta cuenta = cuentaOptional.get();

        cuenta.setNumeroCuenta(dto.getNumeroCuenta());
        cuenta.setTipoProducto(dto.getTipoProducto());
        cuenta.setMoneda(dto.getMoneda());
        cuenta.setMonto(dto.getMonto());
        cuenta.setSucursal(dto.getSucursal());
        cuenta.setEstado(dto.isEstado());
        cuenta.setCreatedAt(dto.getCreatedAt());
        cuenta cuentaActual = cuentaRepository.save(cuenta);
        return cuentaMapper.cuentaToDTO(cuentaActual);

    }
    public void deleteByUuid(UUID uuid) {
        Long id = cuentaRepository.findByUuid(uuid).get().getId();
        cuentaRepository.deleteById(id);
    }
}
