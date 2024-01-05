package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.VentasDetalleEntities;
import com.agrosoft.agrosoft.model.VentasDetalleDTO;
import com.agrosoft.agrosoft.repository.VentasDetalleRepository;
import com.agrosoft.agrosoft.service.VentasDetalleServicio;

@Service
public class VentasDetalleImpl implements VentasDetalleServicio {

    @Autowired
    VentasDetalleRepository ventasDetalleRepository;

    @Override
    public List<VentasDetalleDTO> listVentaDetalles() {
        List<VentasDetalleDTO> ventas = new ArrayList<>();

        ventasDetalleRepository.findAll().forEach((VentasDetalleEntities ventasDetallesEntities) -> {
            ventas.add(new VentasDetalleDTO(ventasDetallesEntities.getId(), ventasDetallesEntities.getCodigo(), ventasDetallesEntities.getFkProducto(), ventasDetallesEntities.getFkVenta(), ventasDetallesEntities.getCantidad(), ventasDetallesEntities.getCreatedAt(), ventasDetallesEntities.getUpdatedAt()));
        });
        return ventas;
    }

    @Override
    public void createdVentaDetalle(List<VentasDetalleDTO> ventasDetalleEntities) {
        ventasDetalleEntities.forEach((VentasDetalleDTO ventasDetalle) -> {
            ventasDetalleRepository.save(new VentasDetalleEntities(ventasDetalle.getId(), ventasDetalle.getCodigo(),
                    ventasDetalle.getFkProducto(), ventasDetalle.getFkVenta(), ventasDetalle.getCantidad(),
                    ventasDetalle.getCreatedAt(), ventasDetalle.getUpdatedAt()));
        });
    }
}
