package com.test.test.cliente;

import com.test.test.cuenta.cuenta;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(unique = true)
    private UUID uuid;

    @Column( length = 100)
    private String nombre;
    @Column(length = 100)
    private String paterno;
    @Column( length = 100)
    private String materno;

    @Column(length = 100)
    private String tipoDocumento;
    @Column( length = 100)
    private String documentoIdentidad;
    @Column( length = 100)
    private String fechaNacimiento;
    @Column(length = 100)
    private String genero;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "estado", length = 100, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean estado ;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.PERSIST)
    private List<cuenta> cuentas;

   // private void initializeUUID() {
   //     this.uuid = UUID.randomUUID();
    //}

    public cliente() {}

    public cliente(String nombre, String paterno, String materno, String tipoDocumento, String documentoIdentidad, String fechaNacimiento,String genero) {
        initializeUUID();
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tipoDocumento = tipoDocumento;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;

    }

    @Override
    public String toString() {
        return "cliente{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", estado=" + estado +
                '}';
    }

    @PrePersist
    private void initializeUUID() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
