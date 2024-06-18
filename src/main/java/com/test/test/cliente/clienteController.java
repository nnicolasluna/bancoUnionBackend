package com.test.test.cliente;

import com.test.test.cuenta.cuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/cliente")
public class clienteController {
    @Autowired
    private clienteService clienteService;

    @GetMapping
    public List<clienteDTO> getAll() {
        return clienteService.getAll();
    }

    @PostMapping
    public cliente create(@RequestBody clienteDTO dto) {
        return clienteService.create(dto);
    }

    @GetMapping("/{uuid}")
    public clienteDTO getOne(@PathVariable String uuid) {
        clienteDTO clienteDTO = clienteService.getOne(UUID.fromString(uuid));
        return clienteDTO;
    }

    @PutMapping
    public clienteDTO edit(@RequestBody clienteDTO dto) {
        return clienteService.edit(dto);
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable String uuid) {
        clienteService.deleteByUuid(UUID.fromString(uuid));
        return ResponseEntity.noContent().build();
    }
}
