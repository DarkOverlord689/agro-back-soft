package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class InventarioUpdateDTO {
    private Long id;
    private String fechaInicialVen;
    private String fechaFinalVen;
    private Long costoProveedor;
    private Long cantidadProveedor;
    private Long valorVenta;
}
