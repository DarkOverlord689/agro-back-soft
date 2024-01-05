package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.CategoriaDTO;

public interface CategoriaServicio {
    List<CategoriaDTO> listCategorias(String codigo);
}
