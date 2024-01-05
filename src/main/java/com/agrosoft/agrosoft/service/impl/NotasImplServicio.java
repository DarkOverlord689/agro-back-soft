package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.NotasEntities;
import com.agrosoft.agrosoft.model.NotasDTO;
import com.agrosoft.agrosoft.repository.NotasRepository;
import com.agrosoft.agrosoft.service.NotasService;

@Service
public class NotasImplServicio implements NotasService {

    @Autowired
    NotasRepository notasRepository;

    @Override
    public List<NotasDTO> listNotas() {
        List<NotasDTO> notas = new ArrayList<>();

        notasRepository.findAll().forEach((NotasEntities notasEntities) -> {
            notas.add(new NotasDTO(notasEntities.getId(), notasEntities.getCodigo(), notasEntities.getOrden(),
                    notasEntities.getDescripcion(), notasEntities.getEstado(), notasEntities.getCreatedAt(),
                    notasEntities.getUpdatedAt()));
        });

        return notas;
    }

    @Override
    public void createdNotas(NotasDTO notas) {

        notasRepository.save(new NotasEntities(null, notas.getCodigo(), notas.getOrden(),
                notas.getDescripcion(), notas.getEstado(), notas.getCreatedAt(),
                notas.getUpdatedAt()));
    }

    @Override
    public void updateNotasName(Long id, String descripcion) {
        notasRepository.updateNotasName(id, descripcion);
    }

    @Override
    public void changeStatusNotas(Long notasId, Long estado) {
        notasRepository.updateNotasStatus(notasId, estado);
    }

    @Override
    public void deleteNotas(Long notasId) {
        notasRepository.deleteById(notasId);
    }

}
