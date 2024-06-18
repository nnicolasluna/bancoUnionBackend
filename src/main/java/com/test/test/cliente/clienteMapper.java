package com.test.test.cliente;

import org.springframework.stereotype.Component;

@Component
public class clienteMapper {

    public cliente clienteToModel(clienteDTO dto) {
        if (dto == null) {
            return null;
        } else {
            return new cliente(
                    dto.getNombre(),
                    dto.getPaterno(),
                    dto.getMaterno(),
                    dto.getTipoDocumento(),
                    dto.getDocumentoIdentidad(),
                    dto.getFechaNacimiento(),
                    dto.getGenero()

            );
        }
    }

    public clienteDTO clienteToDTO(cliente cliente) {
        return new clienteDTO(
                cliente.getUuid(),
                cliente.getNombre(),
                cliente.getPaterno(),
                cliente.getMaterno(),
                cliente.getTipoDocumento(),
                cliente.getDocumentoIdentidad(),
                cliente.getFechaNacimiento(),
                cliente.getGenero()

        );
    }
}
