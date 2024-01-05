package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.model.TiposDTO;
import com.agrosoft.agrosoft.entities.TiposEntities;

import com.agrosoft.agrosoft.repository.TiposRepository;
import com.agrosoft.agrosoft.service.TiposServicio;

@Service
public class TiposServicioImpl implements TiposServicio {

    @Autowired
    TiposRepository tiposRepository;

    @Override
    public List<TiposDTO> listTipos(String codigo) {
        List<TiposDTO> tipos = new ArrayList<>();

        tiposRepository.listTipos(codigo).forEach((TiposEntities tiposEntities) -> {
            TiposDTO tipo = new TiposDTO(tiposEntities.getId(), tiposEntities.getCodigo(), tiposEntities.getNombre(), tiposEntities.getEstado(), tiposEntities.getFkTipoMaestros(), tiposEntities.getCreatedAt(), tiposEntities.getUpdatedAt());
            
            tipos.add(tipo);
         });

        return tipos;
    }
    
}
