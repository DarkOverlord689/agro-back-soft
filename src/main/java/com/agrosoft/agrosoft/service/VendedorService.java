package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.VendedorDTO;

public interface VendedorService {
    List<VendedorDTO> listVendedores();

    void createdVendedores(VendedorDTO vendedorDTO);

    void changeStatusVendedor(Long estado, Long id);
}
