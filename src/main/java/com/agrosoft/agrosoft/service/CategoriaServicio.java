package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.CategoriaDTO;
import com.agrosoft.agrosoft.model.CategoriaMaestraDTO;

public interface CategoriaServicio {

    List<CategoriaMaestraDTO> listCategoriasMaestra();

    List<CategoriaDTO> listCategorias(String codigo);

    void createdCategoriaMaestras(CategoriaMaestraDTO categoriaMaestraDTO);

    void createdCategoria(CategoriaDTO categoriaDTO);

    void changeStatusCategoria(Long id, Long estado);
}
