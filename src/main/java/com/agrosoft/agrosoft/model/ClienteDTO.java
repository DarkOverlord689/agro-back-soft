package com.agrosoft.agrosoft.model;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class ClienteDTO {
    private Long id;
    private String codigo;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long tipoDocumentoId;
    private long numeroDocumento;
    private String correo;
    private String telefono;
    private Long estado;
    private Long tipoGeneroId;
    private String direccion;
    private Timestamp fechaNacimiento;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
