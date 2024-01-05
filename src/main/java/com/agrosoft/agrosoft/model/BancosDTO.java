package com.agrosoft.agrosoft.model;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class BancosDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String segundoTelefono;
    private String correo;
    private Long estado;
    private String sitioWeb;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
