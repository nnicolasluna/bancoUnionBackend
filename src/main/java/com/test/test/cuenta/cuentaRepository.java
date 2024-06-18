package com.test.test.cuenta;

import com.test.test.cliente.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface cuentaRepository extends JpaRepository<cuenta,Long>, JpaSpecificationExecutor<cuenta> {
    Optional<cuenta> findByUuid(UUID uuid);

    List<cuenta> findByCliente(cliente cliente);

  //  void deleteByUuid(UUID uuid);
}
