package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class VendedorDTO {
    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long tipoDocumentoId;
    private long numeroDocumento;
    private String correo;
    private String telefono;
    private Long estado;
    private String username;
    private String password;
    private String cambioContrasena;
    private Long intentosFallidos;
    private String token;
    private Long tipoGeneroId;
    private String direccion;
    private String fechaNacimiento;
    private String createdAt;
    private String updatedAt;
}
