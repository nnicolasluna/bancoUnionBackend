package com.test.test.cliente;

import com.test.test.cuenta.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface clienteRepository extends JpaRepository<cliente,Long>, JpaSpecificationExecutor<cliente> {
    Optional<cliente> findByUuid(UUID uuid);


}
