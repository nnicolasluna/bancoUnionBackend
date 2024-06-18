package com.test.test.cuenta;

import com.test.test.cliente.clienteDTO;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class cuentaDTO {

    @NotNull
    private UUID uuid;
    @NotNull
    private String tipoProducto;
    @NotNull
    private String numeroCuenta;
    @NotNull
    private String moneda;
    @NotNull
    private float monto;
    @NotNull
    private String sucursal;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private boolean estado;

    private UUID cliente;

    public cuentaDTO() {}

    public cuentaDTO(UUID uuid, String tipoProducto, String numeroCuenta, String moneda, float monto, String sucursal, LocalDateTime createdAt, boolean estado) {
        this.uuid = uuid;
        this.tipoProducto = tipoProducto;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.monto = monto;
        this.sucursal = sucursal;
        this.createdAt = createdAt;
        this.estado = estado;

    }

    public cuentaDTO(UUID uuid, String tipoProducto, String numeroCuenta, String moneda, float monto, String sucursal, LocalDateTime createdAt, boolean estado, UUID cliente) {
        this.uuid = uuid;
        this.tipoProducto = tipoProducto;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.monto = monto;
        this.sucursal = sucursal;
        this.createdAt = createdAt;
        this.estado = estado;
        this.cliente = cliente;
    }
}
