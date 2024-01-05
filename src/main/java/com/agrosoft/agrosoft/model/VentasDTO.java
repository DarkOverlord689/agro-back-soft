package com.agrosoft.agrosoft.model;

import lombok.Value;

@Value
public class VentasDTO {
    private Long id;
    private String fechaVenta;
    private Long fkTipoVenta;
    private Long fkVendedor;
    private Long monto;
    private String facturaUrl;
    private Long ingreso;
    private Long egreso;
    private String createdAt;
    private String updatedAt;
}
