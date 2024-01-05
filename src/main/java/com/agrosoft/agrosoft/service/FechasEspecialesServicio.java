package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.FechasEspecialesDTO;

public interface FechasEspecialesServicio {
    List<FechasEspecialesDTO> listFechasEspeciales();
    void createdFechasEspeciales(FechasEspecialesDTO fechasEspecialesDTO);
}
