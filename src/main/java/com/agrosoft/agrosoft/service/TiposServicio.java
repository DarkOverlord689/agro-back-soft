package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.TiposDTO;
import com.agrosoft.agrosoft.model.TiposMaestrosDTO;

public interface TiposServicio {
    List<TiposMaestrosDTO> listTiposMaestra();

    List<TiposDTO> listTipos(String codigo);

    void createdTiposMaestras(TiposMaestrosDTO maestrosDTO);

    void createdTipos(TiposDTO tiposDTO);

    void changeStatusTipos(Long id, Long estado);

}
