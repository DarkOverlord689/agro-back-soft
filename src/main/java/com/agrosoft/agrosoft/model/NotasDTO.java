package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class NotasDTO {
    private Long id;
    private String codigo;
    private Long orden;
    private String descripcion;
    private Long estado;
    private String createdAt;
    private String updatedAt;
}
