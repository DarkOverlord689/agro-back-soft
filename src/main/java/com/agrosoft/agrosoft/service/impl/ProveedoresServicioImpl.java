package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.ProveedoresEntities;
import com.agrosoft.agrosoft.model.ProveedoresDTO;
import com.agrosoft.agrosoft.repository.ProveedoresRepository;
import com.agrosoft.agrosoft.service.ProveedoresServicio;

@Service
public class ProveedoresServicioImpl implements ProveedoresServicio {

    @Autowired
    ProveedoresRepository proveedoresRepository;

    @Override
    public List<ProveedoresDTO> listProveedores() {
        List<ProveedoresDTO> proveedors = new ArrayList<>();
        proveedoresRepository.findAll().forEach((ProveedoresEntities proveedoresEntities) -> {
            ProveedoresDTO proveedor = new ProveedoresDTO(proveedoresEntities.getId(), proveedoresEntities.getCodigo(),
                    proveedoresEntities.getNombre(), proveedoresEntities.getDescripcion(),
                    proveedoresEntities.getTelefono(), proveedoresEntities.getSegundoTelefono(),
                    proveedoresEntities.getCorreo(), proveedoresEntities.getEstado(), proveedoresEntities.getSitioWeb(),
                    proveedoresEntities.getFkBanco(), proveedoresEntities.getNombreBeneficiario(),
                    proveedoresEntities.getNumeroCuenta(), proveedoresEntities.getFechaCreacionEmpresa(),
                    proveedoresEntities.getFkCategoria(), proveedoresEntities.getBrutoAnual(),
                    proveedoresEntities.getCreatedAt(), proveedoresEntities.getUpdatedAt());

            proveedors.add(proveedor);
        });

        return proveedors;
    }

    @Override
    public void createdProveedores(ProveedoresDTO proveedors) {
        ProveedoresEntities proveedor = new ProveedoresEntities(null,
                proveedors.getNombre().substring(0, 3).toUpperCase(), proveedors.getNombre(),
                proveedors.getDescripcion(), proveedors.getTelefono(), proveedors.getSegundoTelefono(),
                proveedors.getCorreo(), proveedors.getEstado(), proveedors.getSitioWeb(), proveedors.getFkBanco(),
                proveedors.getNombreBeneficiario(), proveedors.getNumeroCuenta(), proveedors.getFechaCreacionEmpresa(),
                proveedors.getFkCategoria(), proveedors.getBrutoAnual(), null, null);

        // Suponiendo que el ID ya ha sido generado automáticamente por la base de datos
        proveedoresRepository.save(proveedor);

        // Obtener el ID asignado por la base de datos
        Long idAsignado = proveedor.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = proveedor.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        proveedor.setCodigo(codigoConId);

        // Guardar la entidad actualizada con el código concatenado
        proveedoresRepository.save(proveedor);

    }

    @Override
    public void updateProveedor() {
    }

    @Override
    public void changeStatusProveedor(Long proveedorId, Long estado) {
        proveedoresRepository.updateProveedor(proveedorId, estado);
    }

}
