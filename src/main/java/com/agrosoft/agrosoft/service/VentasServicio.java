package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.VentasDTO;

public interface VentasServicio {

    List<VentasDTO> listVentas();
    Long createdVenta(VentasDTO ventasEntities);
}
