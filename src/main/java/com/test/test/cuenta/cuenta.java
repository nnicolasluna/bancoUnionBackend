package com.test.test.cuenta;

import com.test.test.cliente.cliente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import lombok.EqualsAndHashCode;
@Data
@Entity
public class cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false, length = 100)
    private String tipoProducto;
    @Column(nullable = false, length = 100)
    private String numeroCuenta;
    @Column(nullable = false, length = 100)
    private String moneda;

    @Column(nullable = false, length = 100)
    private float monto;
    @Column(nullable = false, length = 100)
    private String sucursal;
    @Column(length = 100, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean estado;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cliente", nullable = false)
    private cliente cliente;


    private void initializeUUID() {
        this.uuid = UUID.randomUUID();
    }
    public cuenta() {}
    public cuenta(
                  String tipoProducto,
                  String numeroCuenta,
                  String moneda,
                  float monto,
                  String sucursal,
                  boolean estado,
                  cliente cliente) {
        initializeUUID();
        this.tipoProducto = tipoProducto;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.monto = monto;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.estado = estado;
    }

    public cuenta(
                  String tipoProducto,
                  String numeroCuenta,
                  String moneda,
                  float monto,
                  String sucursal,
                  boolean estado,
                  LocalDateTime createdAt) {
        initializeUUID();
        this.tipoProducto = tipoProducto;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.monto = monto;
        this.sucursal = sucursal;
        this.estado = estado;
        this.createdAt = createdAt;
    }

    public cuenta( String tipoProducto, String numeroCuenta, String moneda, float monto, String sucursal, boolean estado, LocalDateTime createdAt, com.test.test.cliente.cliente cliente) {
        initializeUUID();
        this.tipoProducto = tipoProducto;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.monto = monto;
        this.sucursal = sucursal;
        this.estado = estado;
        this.createdAt = createdAt;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "cuenta{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", moneda='" + moneda + '\'' +
                ", monto=" + monto +
                ", sucursal='" + sucursal + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", cliente=" + cliente +
                '}';
    }

    public Long getId() {
        return id;
    }
}
