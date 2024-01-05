package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class VentasDetalleDTO {
    private Long id;
    private String codigo;
    private Long fkProducto;
    private Long fkVenta;
    private Long cantidad;
    private String createdAt;
    private String updatedAt;
}
