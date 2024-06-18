package com.test.test.cliente;

import com.test.test.cuenta.cuentaDTO;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class clienteDTO {

    @NotNull
    private UUID uuid;
    @NotNull
    private String nombre;
    @NotNull
    private String paterno;
    @NotNull
    private String materno;
    @NotNull
    private String tipoDocumento;
    @NotNull
    private String documentoIdentidad;
    @NotNull
    private String fechaNacimiento;
    @NotNull
    private String genero;


    public clienteDTO() {}

    public clienteDTO(UUID uuid, String nombre, String paterno, String materno, String tipoDocumento, String documentoIdentidad, String fechaNacimiento, String genero, boolean estado, List<cuentaDTO> cuenta) {
        this.uuid = uuid;
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
        return "clienteDTO{" +
                "uuid=" + uuid +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", genero='" + genero + '\'' +

                '}';
    }

    public clienteDTO(UUID uuid, String nombre, String paterno, String materno, String tipoDocumento, String documentoIdentidad, String fechaNacimiento, String genero) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tipoDocumento = tipoDocumento;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;


    }

    public clienteDTO(String nombre, String paterno, String materno, String tipoDocumento, String documentoIdentidad, String fechaNacimiento, String genero) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tipoDocumento = tipoDocumento;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;

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


}
