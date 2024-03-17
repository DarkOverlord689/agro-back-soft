package com.agrosoft.agrosoft.service.impl;

import com.agrosoft.agrosoft.model.ClienteDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.ClienteEntities;
import com.agrosoft.agrosoft.repository.ClienteRepository;
import com.agrosoft.agrosoft.service.ClienteServicio;

@Service
public class ClienteImplService implements ClienteServicio {

    @Autowired
    private ClienteRepository usuarioRepository;

    @Override
    public List<ClienteDTO> listUser() {
        List<ClienteDTO> usuario = new ArrayList<>();
        usuarioRepository.findAll().forEach((ClienteEntities usuarios) -> {
            ClienteDTO user = new ClienteDTO(usuarios.getId(), usuarios.getCodigo(), usuarios.getPrimerNombre(),
                    usuarios.getSegundoNombre(), usuarios.getPrimerApellido(), usuarios.getSegundoApellido(),
                    usuarios.getTipoDocumentoId(), usuarios.getNumeroDocumento(), usuarios.getCorreo(),
                    usuarios.getTelefono(), usuarios.getEstado(),
                    usuarios.getTipoGeneroId(), usuarios.getDireccion(), usuarios.getFechaNacimiento(),
                    usuarios.getCreatedAt(), usuarios.getUpdatedAt());
            usuario.add(user);
        });
        return usuario;
    }

    @Override
    public void updateUser() {
    }

    @Override
    public void createdUser(ClienteDTO usuario) {
        ClienteEntities usuariosEntities = new ClienteEntities(null, usuario.getCodigo(), usuario.getPrimerNombre(),
                usuario.getSegundoNombre(), usuario.getPrimerApellido(), usuario.getSegundoApellido(),
                usuario.getTipoDocumentoId(), usuario.getNumeroDocumento(), usuario.getCorreo(),
                usuario.getTelefono(), usuario.getEstado(),
                usuario.getTipoGeneroId(), usuario.getDireccion(), usuario.getFechaNacimiento(),
                null, null);
        usuarioRepository.save(usuariosEntities);
    }

    @Override
    public void changeStatusUser(Long user, Long estado) {
        usuarioRepository.updateUser(user, estado);
    }
}
