package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.NotasDTO;
import com.agrosoft.agrosoft.service.NotasService;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/notas")
public class NotasController {

    @Autowired
    NotasService notasService;

    @GetMapping("/list")
    List<NotasDTO> listNotas(@RequestParam long user) {
        return notasService.listNotas(user);
    }

    @PostMapping("/created-notas")
    void createdNotas(@RequestBody NotasDTO notasDTO) {
        notasService.createdNotas(notasDTO);
    }

    @PutMapping("/change-name-notas")
    void putNotasName(@RequestParam Long id, @RequestParam String descripcion) {
        notasService.updateNotasName(id, descripcion);
    }

    @PutMapping("/change-status-notas")
    void putStatusNotas(@RequestParam Long id, @RequestParam Long estado) {
        notasService.changeStatusNotas(id, estado);
    }

    @DeleteMapping("delete-nota")
    void deleteNotas(@RequestParam Long id) {
        notasService.deleteNotas(id);
    }
}
