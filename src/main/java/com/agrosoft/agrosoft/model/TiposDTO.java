package com.agrosoft.agrosoft.model;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class TiposDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Boolean estado;
    private Long fkTipoMaestros;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
