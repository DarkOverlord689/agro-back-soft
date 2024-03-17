package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.CategoriaEntities;
import com.agrosoft.agrosoft.entities.CategoriaMaestraEntities;
import com.agrosoft.agrosoft.entities.TipoMaestrosEntities;
import com.agrosoft.agrosoft.model.CategoriaDTO;
import com.agrosoft.agrosoft.model.CategoriaMaestraDTO;
import com.agrosoft.agrosoft.repository.CategoriaMaestraRepository;
import com.agrosoft.agrosoft.repository.CategoriaRepository;
import com.agrosoft.agrosoft.service.CategoriaServicio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaMaestraRepository categoriaMaestraRepository;

    @Override
    public List<CategoriaDTO> listCategorias(String codigo) {
        List<CategoriaDTO> categorias = new ArrayList<>();

        categoriaRepository.listCategorias(codigo).forEach((CategoriaEntities categoriaEntities) -> {
            CategoriaDTO categoria = new CategoriaDTO(categoriaEntities.getId(), categoriaEntities.getCodigo(),
                    categoriaEntities.getNombre(),
                    categoriaEntities.getFkCategoriaMaestra(), categoriaEntities.getEstado(),
                    categoriaEntities.getCreatedAt(),
                    categoriaEntities.getUpdatedAt());

            categorias.add(categoria);
        });

        return categorias;
    }

    @Override
    public List<CategoriaMaestraDTO> listCategoriasMaestra() {
        Iterable<CategoriaMaestraEntities> entidades = categoriaMaestraRepository.findAll();

        List<CategoriaMaestraDTO> dtos = new ArrayList<>();

        // Iterar sobre el Iterable y mapear cada entidad a su DTO correspondiente
        for (CategoriaMaestraEntities entidad : entidades) {
            CategoriaMaestraDTO dto = entidad.toDTO();
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public void createdCategoria(CategoriaDTO categoriaDTO) {
        CategoriaEntities categoria = new CategoriaEntities(null, categoriaDTO.getCodigo(), categoriaDTO.getNombre(),
                null, categoriaDTO.getFkCategoriaMaestra(), null, null);
        categoriaRepository.save(categoria);

        // Obtener el ID asignado por la base de datos
        Long idAsignado = categoria.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = categoria.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        categoria.setCodigo(codigoConId);

        // Guardar la entidad actualizada con el código concatenado
        categoriaRepository.save(categoria);
    }

    @Override
    public void createdCategoriaMaestras(CategoriaMaestraDTO categoriaMaestraDTO) {
        CategoriaMaestraEntities categoria = new CategoriaMaestraEntities(null, categoriaMaestraDTO.getCodigo(), categoriaMaestraDTO.getNombre(), null, null, null);

        categoriaMaestraRepository.save(categoria);
        // Obtener el ID asignado por la base de datos
        Long idAsignado = categoria.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = categoria.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        categoria.setCodigo(codigoConId);

        // Guardar la entidad actualizada con el código concatenado
        categoriaMaestraRepository.save(categoria);
    }

    @Override
    public void changeStatusCategoria(Long id, Long estado) {
        categoriaRepository.changeStatus(id, estado);
    }
}
