package com.agrosoft.agrosoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotasDTO {
    private Long id;
    private String codigo;
    private Long orden;
    private String descripcion;
    private Long estado;
    private Long fkUser;
    private String createdAt;
    private String updatedAt;
}
