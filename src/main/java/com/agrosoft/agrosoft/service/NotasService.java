package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.NotasDTO;

public interface NotasService {
    List<NotasDTO> listNotas(Long user);

    void createdNotas(NotasDTO notas);

    void updateNotasName(Long id, String descripcion);

    void changeStatusNotas(Long notasId, Long estado);

    void deleteNotas(Long notasId);
}
