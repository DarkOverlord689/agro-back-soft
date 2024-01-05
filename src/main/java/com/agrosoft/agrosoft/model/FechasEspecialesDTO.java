package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class FechasEspecialesDTO {
    private Long id;
    private String codigo;
    private String fecha;
    private String descripcion;
    private String icono;
    private Long estado;
    private String createdAt;
    private String updatedAt;
}
