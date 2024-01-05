package com.agrosoft.agrosoft.entities;

import java.sql.Timestamp;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventario")
public class InventarioEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String nombre;

    @Column(name = "fk_categoria")
    private Long fkCategoria;

    @Column(name = "fk_proveedor")
    private Long fkProveedor;

    @Column(name = "fecha_inicial_ven")
    private Timestamp fechaInicialVen;

    @Column(name = "fecha_final_ven")
    private Timestamp fechaFinalVen;

    @Column(name = "costo_proveedor")
    private Long costoProveedor;

    @Column(name = "cantidad_proveedor")
    private Long cantidadProveedor;

    @Column(name = "valor_venta")
    private Long valorVenta;

    private String descripcion;

    private Long estado;

    private String foto;

    @Column(name = "codigo_qr")
    private String codigoQR;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
