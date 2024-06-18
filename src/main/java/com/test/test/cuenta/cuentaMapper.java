package com.test.test.cuenta;

import com.test.test.cliente.cliente;
import com.test.test.cliente.clienteMapper;
import com.test.test.cliente.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class cuentaMapper {
    @Autowired
    private clienteMapper clienteMapper;
    @Autowired
    private clienteRepository clienteRepository;
    public cuenta cuentaToModel(cuentaDTO dto){
        cliente cliente = null;
        if (dto.getCliente() != null) {
            cliente = clienteRepository.findByUuid(dto.getUuid()).orElse(null);
        }
        return new cuenta(
                dto.getTipoProducto(),
                dto.getNumeroCuenta(),
                dto.getMoneda(),
                dto.getMonto(),
                dto.getSucursal(),
                dto.isEstado(),
                dto.getCreatedAt(),
                cliente
        );
    }
    public  cuentaDTO cuentaToDTO(cuenta cuenta){
        return new cuentaDTO(
                cuenta.getUuid(),
                cuenta.getTipoProducto(),
                cuenta.getNumeroCuenta(),
                cuenta.getMoneda(),
                cuenta.getMonto(),
                cuenta.getSucursal(),
                cuenta.getCreatedAt(),
                cuenta.isEstado(),
                cuenta.getCliente()!= null ? cuenta.getCliente().getUuid() : null
        );
    }
}
