package com.agrosoft.agrosoft.service.impl;

import com.agrosoft.agrosoft.model.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.UsuariosEntities;
import com.agrosoft.agrosoft.repository.UsuarioRepository;
import com.agrosoft.agrosoft.service.UsuarioServicio;

@Service
public class UsuariosServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> listUser() {
        List<UsuarioDTO> usuario = new ArrayList<>();
        usuarioRepository.findAll().forEach((UsuariosEntities usuarios) -> {
            UsuarioDTO user = new UsuarioDTO(usuarios.getId(), usuarios.getCodigo(), usuarios.getPrimerNombre(),
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
    public void createdUser(UsuarioDTO usuario) {
        UsuariosEntities usuariosEntities = new UsuariosEntities(null, usuario.getCodigo(), usuario.getPrimerNombre(),
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
