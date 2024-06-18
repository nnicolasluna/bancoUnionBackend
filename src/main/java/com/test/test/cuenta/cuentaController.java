package com.test.test.cuenta;

import com.test.test.cliente.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/cuenta")
public class cuentaController {
    @Autowired
    private cuentaService cuentaService;

    @GetMapping
    public List<cuentaDTO> getAll() {
        return cuentaService.getAll();
    }

    @PostMapping
    public cuentaDTO create(@RequestBody cuentaDTO dto) {
        return cuentaService.create(dto);
    }

    @GetMapping("/{uuid}")
    public cuentaDTO getOne(@PathVariable String uuid) {
        cuentaDTO cuentaDTO = cuentaService.getOne(UUID.fromString(uuid));
        return cuentaDTO;
    }
    @GetMapping("cliente/{uuid}")
    public List<cuentaDTO> getByClienteUUID(@PathVariable String uuid) {
        return cuentaService.getByClienteUUID(UUID.fromString(uuid));
    }
    @PutMapping
    public cuentaDTO edit(@RequestBody cuentaDTO dto) {
        return cuentaService.edit(dto);
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable String uuid) {
        cuentaService.deleteByUuid(UUID.fromString(uuid));
        return ResponseEntity.noContent().build();
    }
}
