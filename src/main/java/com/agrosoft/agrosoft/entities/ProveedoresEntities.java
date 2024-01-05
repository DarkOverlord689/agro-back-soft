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
@Table(name = "proveedores")
public class ProveedoresEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String nombre;

    private String descripcion;

    private String telefono;

    @Column(name = "segundo_telefono")
    private String segundoTelefono;

    private String correo;

    private Long estado;

    @Column(name = "sitio_web")
    private String sitioWeb;

    @Column(name = "fk_banco")
    private Long fkBanco;

    @Column(name = "nombre_beneficiario")
    private String nombreBeneficiario;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "fecha_creacion_empresa")
    private Timestamp fechaCreacionEmpresa;

    @Column(name = "fk_categoria")
    private Long fkCategoria;

    @Column(name = "bruto_anual")
    private Long brutoAnual;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
