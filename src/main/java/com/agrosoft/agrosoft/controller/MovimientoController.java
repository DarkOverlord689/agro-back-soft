package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.VentasDetalleDTO;
import com.agrosoft.agrosoft.service.VentasDetalleServicio;

@RestController
@RequestMapping(value = "api/v1/movimientos")
public class MovimientoController {
        @Autowired
    VentasDetalleServicio ventasDetalleServicio;

    @GetMapping("list-venta-detalle")
    List<VentasDetalleDTO> getVentaDetalle() {
        return ventasDetalleServicio.listVentaDetalles();
    }
}
