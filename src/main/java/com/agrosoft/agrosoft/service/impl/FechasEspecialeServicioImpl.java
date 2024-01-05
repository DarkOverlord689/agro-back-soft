package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.FechasEspecialesEntities;
import com.agrosoft.agrosoft.model.FechasEspecialesDTO;
import com.agrosoft.agrosoft.repository.FechasEspecialesRepository;
import com.agrosoft.agrosoft.service.FechasEspecialesServicio;

@Service
public class FechasEspecialeServicioImpl implements FechasEspecialesServicio {

    @Autowired
    FechasEspecialesRepository fechasEspecialesRepository;

    @Override
    public List<FechasEspecialesDTO> listFechasEspeciales() {
        List<FechasEspecialesDTO> fechasEspecialesDTO = new ArrayList<>();

        fechasEspecialesRepository.findAll().forEach((FechasEspecialesEntities fechaEspecial) -> {
            fechasEspecialesDTO.add(new FechasEspecialesDTO(fechaEspecial.getId(), fechaEspecial.getCodigo(),
                    fechaEspecial.getFecha(), fechaEspecial.getDescripcion(), fechaEspecial.getIcono(),
                    fechaEspecial.getEstado(), fechaEspecial.getCreatedAt(), fechaEspecial.getUpdatedAt()));
        });

        return fechasEspecialesDTO;

    }

    @Override
    public void createdFechasEspeciales(FechasEspecialesDTO fechasEspecialesDTO) {
        System.out.println(fechasEspecialesDTO);
        fechasEspecialesRepository.save(new FechasEspecialesEntities(null,
                fechasEspecialesDTO.getCodigo(), fechasEspecialesDTO.getFecha(), fechasEspecialesDTO.getDescripcion(),
                fechasEspecialesDTO.getIcono(), fechasEspecialesDTO.getEstado(), fechasEspecialesDTO
                        .getCreatedAt(),
                fechasEspecialesDTO.getUpdatedAt()));
    }

}
