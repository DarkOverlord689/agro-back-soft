package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.model.TiposDTO;
import com.agrosoft.agrosoft.model.TiposMaestrosDTO;
import com.agrosoft.agrosoft.entities.TipoMaestrosEntities;
import com.agrosoft.agrosoft.entities.TiposEntities;
import com.agrosoft.agrosoft.repository.TiposMaestrosRepository;
import com.agrosoft.agrosoft.repository.TiposRepository;
import com.agrosoft.agrosoft.service.TiposServicio;

@Service
public class TiposServicioImpl implements TiposServicio {

    @Autowired
    TiposRepository tiposRepository;

    @Autowired
    TiposMaestrosRepository tiposMaestrosRepository;

    @Override
    public List<TiposDTO> listTipos(String codigo) {
        List<TiposDTO> tipos = new ArrayList<>();

        tiposRepository.listTipos(codigo).forEach((TiposEntities tiposEntities) -> {
            TiposDTO tipo = new TiposDTO(tiposEntities.getId(), tiposEntities.getCodigo(), tiposEntities.getNombre(),
                    tiposEntities.getEstado(), tiposEntities.getFkTipoMaestros(), tiposEntities.getCreatedAt(),
                    tiposEntities.getUpdatedAt());

            tipos.add(tipo);
        });

        return tipos;
    }

    @Override
    public List<TiposMaestrosDTO> listTiposMaestra() {
        Iterable<TipoMaestrosEntities> entidades = tiposMaestrosRepository.findAll();

        List<TiposMaestrosDTO> dtos = new ArrayList<>();

        // Iterar sobre el Iterable y mapear cada entidad a su DTO correspondiente
        for (TipoMaestrosEntities entidad : entidades) {
            TiposMaestrosDTO dto = entidad.toDTO();
            dtos.add(dto);
        }

        return dtos;

    }

    @Override
    public void createdTiposMaestras(TiposMaestrosDTO maestrosDTO) {
        TipoMaestrosEntities tipo = new TipoMaestrosEntities(null, maestrosDTO.getCodigo(),
                maestrosDTO.getNombre(), maestrosDTO.getEstado(),
                maestrosDTO.getCreatedAt(), maestrosDTO.getUpdatedAt());

        tiposMaestrosRepository.save(tipo);
        // Obtener el ID asignado por la base de datos
        Long idAsignado = tipo.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = tipo.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        tipo.setCodigo(codigoConId);

        // Guardar la entidad actualizada con el código concatenado
        tiposMaestrosRepository.save(tipo);
    }

    @Override
    public void createdTipos(TiposDTO tiposDTO) {

        TiposEntities tipo = new TiposEntities(null, tiposDTO.getCodigo(), tiposDTO.getNombre(),
                null, tiposDTO.getFkTipoMaestros(), null, null);
        tiposRepository.save(tipo);

        // Obtener el ID asignado por la base de datos
        Long idAsignado = tipo.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = tipo.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        tipo.setCodigo(codigoConId);

        // Guardar la entidad actualizada con el código concatenado
        tiposRepository.save(tipo);
    }

    @Override
    public void changeStatusTipos(Long id, Long estado) {
        tiposRepository.changeStatus(id, estado);
    }

}
