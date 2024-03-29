package com.agrosoft.agrosoft.model;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class CategoriaDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Long fkCategoriaMaestra;
    private Boolean estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
