package com.agrosoft.agrosoft.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ventas")
public class VentasEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_venta")
    private String fechaVenta;

    @Column(name = "fk_tipo_venta")
    private Long fkTipoVenta;

    @Column(name = "fk_vendedor")
    private Long fkVendedor;

    private Long monto;

    @Column(name = "factura_url")
    private String facturaUrl;

    private Long ingreso;

    private Long egreso;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
