package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.VentasEntities;
import com.agrosoft.agrosoft.model.VentasDTO;
import com.agrosoft.agrosoft.repository.VentasRepository;
import com.agrosoft.agrosoft.service.VentasServicio;

@Service
public class VentasImpl implements VentasServicio {

    @Autowired
    VentasRepository ventasRepository;

    @Override
    public List<VentasDTO> listVentas() {
        List<VentasDTO> ventas = new ArrayList<>();

        ventasRepository.findAll().forEach((VentasEntities ventasEntities) -> {
            VentasDTO venta = new VentasDTO(ventasEntities.getId(), ventasEntities.getFechaVenta(), ventasEntities.getFkTipoVenta(), ventasEntities.getFkVendedor(), ventasEntities.getMonto(), ventasEntities.getFacturaUrl(), ventasEntities.getIngreso(), ventasEntities.getEgreso(), ventasEntities.getCreatedAt(), ventasEntities.getUpdatedAt());

            ventas.add(venta);
        });
        return ventas;
    }

    @Override
    public Long createdVenta(VentasDTO ventas) {
        VentasEntities ventaGuardada = ventasRepository.save(new VentasEntities(null, ventas.getFechaVenta(), ventas.getFkTipoVenta(),
                ventas.getFkVendedor(), ventas.getMonto(), ventas.getFacturaUrl(), ventas.getIngreso(),
                ventas.getEgreso(), ventas.getCreatedAt(), ventas.getUpdatedAt()));
        return ventaGuardada.getId(); // Retorna el ID de la venta guardada
    }
}
