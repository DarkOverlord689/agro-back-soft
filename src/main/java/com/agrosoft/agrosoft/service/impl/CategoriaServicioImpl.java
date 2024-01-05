package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.CategoriaEntities;
import com.agrosoft.agrosoft.model.CategoriaDTO;
import com.agrosoft.agrosoft.repository.CategoriaRepository;
import com.agrosoft.agrosoft.service.CategoriaServicio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listCategorias(String codigo) {
        List<CategoriaDTO> categorias = new ArrayList<>();

        categoriaRepository.listCategorias(codigo).forEach((CategoriaEntities categoriaEntities) -> {
            CategoriaDTO categoria = new CategoriaDTO(categoriaEntities.getId(), categoriaEntities.getCodigo(),
                    categoriaEntities.getNombre(), categoriaEntities.getDescripcion(),
                    categoriaEntities.getFkCategoriaMaestra(), categoriaEntities.getCreatedAt(),
                    categoriaEntities.getUpdatedAt());

            categorias.add(categoria);
        });

        return categorias;
    };

}
