package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.entities.InventarioEntities;
import com.agrosoft.agrosoft.model.InventarioDTO;
import com.agrosoft.agrosoft.model.InventarioUpdateDTO;
import com.agrosoft.agrosoft.model.VentasDetalleDTO;

public interface InventarioServicio {
    List<InventarioDTO> listInventario();

    List<InventarioDTO> listInventarioDisponible();

    List<VentasDetalleDTO> listVentasByProducto(Long producto);

    List<InventarioEntities> listInventarioProveedor(Long proveedorId);

    List<InventarioDTO> listInventarioProveedorMapeo(Long proveedorId);

    void createdInventario(InventarioDTO inventario);

    void changeStatusInventario(Long inventarioId, Long estado);

    void updateInventario(InventarioUpdateDTO inventarioUpdateDTO);
}
