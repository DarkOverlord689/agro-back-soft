package com.agrosoft.agrosoft.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<NotasDTO> listNotas(Long user) {
        List<NotasDTO> notas = new ArrayList<>();

        notasRepository.listNotasByUser(user).forEach((NotasEntities notasEntities) -> {
            notas.add(new NotasDTO(notasEntities.getId(), notasEntities.getCodigo(), notasEntities.getOrden(),
                    notasEntities.getDescripcion(), notasEntities.getEstado(), notasEntities.getFkUser(),
                    notasEntities.getCreatedAt(),
                    notasEntities.getUpdatedAt()));
        });

        return notas;
    }

    @Override
    public void createdNotas(NotasDTO notas) {
        // Establecer una fecha por defecto
        Date fechaPorDefecto = new Date(); // Esto inicializa la fecha con el tiempo actual

        // Convertir la fecha a una cadena de texto (string)
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaComoString = formatoFecha.format(fechaPorDefecto);
        notas.setCreatedAt(fechaComoString);
        notas.setUpdatedAt(fechaComoString);

        NotasEntities notasEntities = new NotasEntities(null, notas.getDescripcion().substring(0,3).toUpperCase(), notas.getOrden(),
        notas.getDescripcion(), notas.getEstado(), notas.getFkUser(), notas.getCreatedAt(),
        notas.getUpdatedAt());

        notasRepository.save(notasEntities);

        // Obtener el ID asignado por la base de datos
        Long idAsignado = notasEntities.getId();

        // Concatenar el ID al código del proveedor
        String codigoConId = notasEntities.getCodigo() + "_" + idAsignado;

        // Actualizar el código del proveedor con el ID concatenado
        notasEntities.setCodigo(codigoConId);
        notasEntities.setOrden(idAsignado);

        // Guardar la entidad actualizada con el código concatenado
        notasRepository.save(notasEntities);
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
