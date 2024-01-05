package com.agrosoft.agrosoft.model;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class InventarioDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Long fkCategoria;
    private Long fkProveedor;
    private Timestamp fechaInicialVen;
    private Timestamp fechaFinalVen;
    private Long costoProveedor;
    private Long cantidadProveedor;
    private Long valorVenta;
    private String descripcion;
    private Long estado;
    private String foto;
    private String codigoQR;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
