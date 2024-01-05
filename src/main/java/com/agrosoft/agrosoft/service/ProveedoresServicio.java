package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.ProveedoresDTO;

public interface ProveedoresServicio {
    List<ProveedoresDTO> listProveedores();

    void createdProveedores(ProveedoresDTO usuario);

    void updateProveedor();

    void changeStatusProveedor(Long proveedorId, Long estado);
}
