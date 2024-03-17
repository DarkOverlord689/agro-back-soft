package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.ClienteDTO;

public interface ClienteServicio {
    
    List<ClienteDTO> listUser();
    void createdUser(ClienteDTO usuario);
    void updateUser();
    void changeStatusUser(Long user, Long estado);
}
