package com.test.test.cliente;


import com.test.test.cuenta.cuenta;
import com.test.test.cuenta.cuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class clienteService {
    @Autowired
    private clienteRepository clienteRepository;

    @Autowired
    private clienteMapper clienteMapper;

    public List<clienteDTO> getAll() {
        List<cliente> clientes = clienteRepository.findAll();
        return clientes
                .stream()
                .map(clienteMapper::clienteToDTO)
                .collect(Collectors.toList());
    }

    public cliente create(clienteDTO clienteDTO) {
        cliente cliente = clienteMapper.clienteToModel(clienteDTO);
        cliente clienteSaved = clienteRepository.save(cliente);
       // return clienteMapper.clienteToDTO(clienteSaved);
        return clienteSaved;
    }
    public clienteDTO getOne(UUID uuid) {
        Optional<cliente> optionalCliente = clienteRepository.findByUuid(uuid);
        clienteDTO clienteDTO = clienteMapper.clienteToDTO(optionalCliente.get());
        return clienteDTO;
    }

    public clienteDTO edit(clienteDTO dto) {
        Optional<cliente> clienteOptional = clienteRepository.findByUuid(dto.getUuid());
        cliente cliente = clienteOptional.get();

        cliente.setNombre(dto.getNombre());
        cliente.setPaterno(dto.getPaterno());
        cliente.setMaterno(dto.getMaterno());
        cliente.setGenero(dto.getGenero());
        cliente.setTipoDocumento(dto.getTipoDocumento());
        cliente.setDocumentoIdentidad(dto.getDocumentoIdentidad());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());

        cliente clienteActual = clienteRepository.save(cliente);
        return clienteMapper.clienteToDTO(clienteActual);

    }


    public void deleteByUuid(UUID uuid) {
        Long id = clienteRepository.findByUuid(uuid).get().getId();
        clienteRepository.deleteById(id);
    }
}
