package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.UsuarioDTO;
import com.agrosoft.agrosoft.service.UsuarioServicio;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/list")
    List<UsuarioDTO> getUsuarios() {
        return usuarioServicio.listUser();
    }

    @PostMapping("/created-user")
    void postUser(@RequestBody UsuarioDTO usuario) {
        usuarioServicio.createdUser(usuario);
    }

    @PutMapping("/update-status")
    void putStatusUser(@RequestParam Long user, @RequestParam Long estado) {
        usuarioServicio.changeStatusUser(user, estado);
    }
}
