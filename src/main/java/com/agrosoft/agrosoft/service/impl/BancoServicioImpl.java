package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.BancoEntities;
import com.agrosoft.agrosoft.model.BancosDTO;
import com.agrosoft.agrosoft.repository.BancoRepository;
import com.agrosoft.agrosoft.service.BancoServicio;

@Service
public class BancoServicioImpl implements BancoServicio {

    @Autowired
    BancoRepository bancoRepository;

    @Override
    public List<BancosDTO> listBancos() {
        List<BancosDTO> bancos = new ArrayList<>();

        bancoRepository.findAll().forEach((BancoEntities bancosEntities) -> {
            BancosDTO banco = new BancosDTO(bancosEntities.getId(), bancosEntities.getCodigo(), bancosEntities.getNombre(), bancosEntities.getDescripcion(), bancosEntities.getTelefono(), bancosEntities.getSegundoTelefono(), bancosEntities.getCorreo(), bancosEntities.getEstado(), bancosEntities.getSitioWeb(), bancosEntities.getCreatedAt(), bancosEntities.getUpdatedAt());

            bancos.add(banco);
        });

        return bancos;
    }

    @Override
    public void changeStatusBancos(Long id, Long estado) {
        bancoRepository.changeStatusBancos(id, estado);
    }
    
}
