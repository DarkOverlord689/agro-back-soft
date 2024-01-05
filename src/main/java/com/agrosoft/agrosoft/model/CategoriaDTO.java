package com.agrosoft.agrosoft.model;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class CategoriaDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Long fkCategoriaMaestra;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
