package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class CategoriaMaestraDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Boolean estado;
    private String createdAt;
    private String updatedAt;
}
