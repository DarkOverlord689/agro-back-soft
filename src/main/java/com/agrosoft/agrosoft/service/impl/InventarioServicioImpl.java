package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.InventarioEntities;
import com.agrosoft.agrosoft.entities.VentasDetalleEntities;
import com.agrosoft.agrosoft.model.InventarioDTO;
import com.agrosoft.agrosoft.model.InventarioUpdateDTO;
import com.agrosoft.agrosoft.model.VentasDetalleDTO;
import com.agrosoft.agrosoft.repository.InventarioRepository;
import com.agrosoft.agrosoft.repository.VentasDetalleRepository;
import com.agrosoft.agrosoft.service.InventarioServicio;

@Service
public class InventarioServicioImpl implements InventarioServicio {

    @Autowired
    InventarioRepository inventarioRepository;

    @Autowired
    VentasDetalleRepository ventasDetalleRepository;

    @Override
    public List<InventarioDTO> listInventario() {

        List<InventarioDTO> inventario = new ArrayList<>();

        inventarioRepository.findAll().forEach((InventarioEntities inventarioEntities) -> {
            InventarioDTO inventarios = new InventarioDTO(inventarioEntities.getId(), inventarioEntities.getCodigo(),
                    inventarioEntities.getNombre(), inventarioEntities.getFkCategoria(),
                    inventarioEntities.getFkProveedor(), inventarioEntities.getFechaInicialVen(),
                    inventarioEntities.getFechaFinalVen(), inventarioEntities.getCostoProveedor(),
                    inventarioEntities.getCantidadProveedor(), inventarioEntities.getValorVenta(),
                    inventarioEntities.getDescripcion(), inventarioEntities.getEstado(), inventarioEntities.getFoto(),
                    inventarioEntities.getCodigoQR(), inventarioEntities.getCreatedAt(),
                    inventarioEntities.getUpdatedAt());

            inventario.add(inventarios);
        });

        return inventario;
    }

    @Override
    public List<InventarioDTO> listInventarioDisponible() {
        List<InventarioDTO> inventario = new ArrayList<>();

        inventarioRepository.listInventarioDisponible().forEach((InventarioEntities inventarioEntities) -> {
            InventarioDTO inventarios = new InventarioDTO(inventarioEntities.getId(), inventarioEntities.getCodigo(),
                    inventarioEntities.getNombre(), inventarioEntities.getFkCategoria(),
                    inventarioEntities.getFkProveedor(), inventarioEntities.getFechaInicialVen(),
                    inventarioEntities.getFechaFinalVen(), inventarioEntities.getCostoProveedor(),
                    inventarioEntities.getCantidadProveedor(), inventarioEntities.getValorVenta(),
                    inventarioEntities.getDescripcion(), inventarioEntities.getEstado(), inventarioEntities.getFoto(),
                    inventarioEntities.getCodigoQR(), inventarioEntities.getCreatedAt(),
                    inventarioEntities.getUpdatedAt());

            inventario.add(inventarios);
        });

        return inventario;
    }

    @Override
    public List<VentasDetalleDTO> listVentasByProducto(Long producto) {
        List<VentasDetalleDTO> ventas = new ArrayList<>();

        ventasDetalleRepository.findAll().forEach((VentasDetalleEntities ventasDetallesEntities) -> {
            ventas.add(new VentasDetalleDTO(ventasDetallesEntities.getId(), ventasDetallesEntities.getCodigo(),
                    ventasDetallesEntities.getFkProducto(), ventasDetallesEntities.getFkVenta(),
                    ventasDetallesEntities.getCantidad(), ventasDetallesEntities.getCreatedAt(),
                    ventasDetallesEntities.getUpdatedAt()));
        });
        return ventas;
    }

    @Override
    public List<InventarioEntities> listInventarioProveedor(Long proveedorId) {
        return inventarioRepository.listInventarioProveedor(proveedorId);
    }

    @Override
    public List<InventarioDTO> listInventarioProveedorMapeo(Long proveedorId) {
        List<InventarioDTO> inventario = new ArrayList<>();

        listInventarioProveedor(proveedorId).forEach((InventarioEntities inventarioEntities) -> {
            InventarioDTO inventarios = new InventarioDTO(inventarioEntities.getId(), inventarioEntities.getCodigo(),
                    inventarioEntities.getNombre(), inventarioEntities.getFkCategoria(),
                    inventarioEntities.getFkProveedor(), inventarioEntities.getFechaInicialVen(),
                    inventarioEntities.getFechaFinalVen(), inventarioEntities.getCostoProveedor(),
                    inventarioEntities.getCantidadProveedor(), inventarioEntities.getValorVenta(),
                    inventarioEntities.getDescripcion(), inventarioEntities.getEstado(), inventarioEntities.getFoto(),
                    inventarioEntities.getCodigoQR(), inventarioEntities.getCreatedAt(),
                    inventarioEntities.getUpdatedAt());

            inventario.add(inventarios);
        });

        return inventario;
    }

    @Override
    public void createdInventario(InventarioDTO inventario) {
        InventarioEntities inventarios = new InventarioEntities(null,
                inventario.getNombre().substring(0, 3).toUpperCase(),
                inventario.getNombre(), inventario.getFkCategoria(), inventario.getFkProveedor(),
                inventario.getFechaInicialVen(), inventario.getFechaFinalVen(), inventario.getCostoProveedor(),
                inventario.getCantidadProveedor(), inventario.getValorVenta(),
                inventario.getDescripcion(), inventario.getEstado(), inventario.getFoto(), inventario.getCodigoQR(),
                null, null);

        // Suponiendo que el ID ya ha sido generado automáticamente por la base de datos
        inventarioRepository.save(inventarios);

        // Obtener el ID asignado por la base de datos
        Long idAsignado = inventarios.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = inventarios.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        inventarios.setCodigo(codigoConId);

        // Guardar la entidad actualizada con el código concatenado
        inventarioRepository.save(inventarios);
    }

    @Override
    public void changeStatusInventario(Long inventarioId, Long estado) {
        inventarioRepository.updateInventario(inventarioId, estado);
    }

    @Override
    public void updateInventario(InventarioUpdateDTO inventarioUpdateDTO) {
        inventarioRepository.updateInventario(inventarioUpdateDTO.getFechaInicialVen(),
                inventarioUpdateDTO.getFechaFinalVen(), inventarioUpdateDTO.getCostoProveedor(),
                inventarioUpdateDTO.getCantidadProveedor(), inventarioUpdateDTO.getValorVenta(),
                inventarioUpdateDTO.getId());
    }
}
