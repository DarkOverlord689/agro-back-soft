package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.VentasDTO;
import com.agrosoft.agrosoft.model.VentasDetalleDTO;
import com.agrosoft.agrosoft.service.VentasDetalleServicio;
import com.agrosoft.agrosoft.service.VentasServicio;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "api/v1/ventas")
public class VentasController {

    @Autowired
    VentasServicio ventasServicio;

    @Autowired
    VentasDetalleServicio ventasDetalleServicio;

    @GetMapping("list")
    List<VentasDTO> getVentas() {
        return ventasServicio.listVentas();
    }

    @PostMapping("created-venta")
    Long postVenta(@RequestBody VentasDTO ventasDTO) {
       return ventasServicio.createdVenta(ventasDTO);
    }

    @PostMapping("created-venta-detalle")
    void postVentaDetalle(@RequestBody List<VentasDetalleDTO> ventasDTO) {
        ventasDetalleServicio.createdVentaDetalle(ventasDTO);
    }
}
