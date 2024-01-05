package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.UsuarioDTO;

public interface UsuarioServicio {
    
    List<UsuarioDTO> listUser();
    void createdUser(UsuarioDTO usuario);
    void updateUser();
    void changeStatusUser(Long user, Long estado);
}
