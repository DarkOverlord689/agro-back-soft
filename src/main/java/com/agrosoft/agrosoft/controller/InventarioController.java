package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.InventarioDTO;
import com.agrosoft.agrosoft.model.InventarioUpdateDTO;
import com.agrosoft.agrosoft.model.VentasDetalleDTO;
import com.agrosoft.agrosoft.service.InventarioServicio;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "/api/v1/inventario")
public class InventarioController {
    @Autowired
    InventarioServicio inventarioServicio;

    @GetMapping("/list")
    List<InventarioDTO> getInventario() {
        return inventarioServicio.listInventario();
    }

    @GetMapping("/list-disponible")
    List<InventarioDTO> listInventarioDisponible() {
        return inventarioServicio.listInventarioDisponible();
    }

    @GetMapping("/list-detalle-venta")
    List<VentasDetalleDTO> listVentasByProducto(@RequestParam Long producto) {
        return inventarioServicio.listVentasByProducto(producto);
    }

    @GetMapping("/list-by-proveedor")
    List<InventarioDTO> getInventarioByProveedor(@RequestParam Long proveedorId) {
        return inventarioServicio.listInventarioProveedorMapeo(proveedorId);
    }

    @PostMapping("/created-inventario")
    void postInventario(@RequestBody InventarioDTO inventario) {
        inventarioServicio.createdInventario(inventario);
    }

    @PutMapping("/update-status")
    void putStatusInventari(@RequestParam Long inventarioId, @RequestParam Long estado) {
        inventarioServicio.changeStatusInventario(inventarioId, estado);
    }

    @PutMapping("/update-inventario")
    void putStatusInventari(@RequestBody InventarioUpdateDTO inventarioUpdateDTO) {
        inventarioServicio.updateInventario(inventarioUpdateDTO);
    }
}
