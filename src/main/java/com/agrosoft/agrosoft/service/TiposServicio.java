package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.TiposDTO;

public interface TiposServicio {
    List<TiposDTO> listTipos(String codigo);
}
