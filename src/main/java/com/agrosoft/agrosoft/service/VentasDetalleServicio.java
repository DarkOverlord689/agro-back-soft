package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.VentasDetalleDTO;

public interface VentasDetalleServicio {

    List<VentasDetalleDTO> listVentaDetalles();
    void createdVentaDetalle(List<VentasDetalleDTO> ventasDetalleEntities);
}
