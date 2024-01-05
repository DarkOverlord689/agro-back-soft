package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.BancosDTO;
import com.agrosoft.agrosoft.model.CategoriaDTO;
import com.agrosoft.agrosoft.model.TiposDTO;
import com.agrosoft.agrosoft.service.BancoServicio;
import com.agrosoft.agrosoft.service.CategoriaServicio;
import com.agrosoft.agrosoft.service.TiposServicio;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/configuracion")
public class ConfiguracionController {
    
    @Autowired
    BancoServicio bancoServicio;

    @Autowired
    TiposServicio tiposServicio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping("/list-bancos")
    List<BancosDTO> listBancos() {
        return bancoServicio.listBancos();
    }

    @GetMapping("/list-tipos")
    List<TiposDTO> listTipos(@RequestParam String codigo) {
        return tiposServicio.listTipos(codigo);
    }

    @GetMapping("/list-categorias")
    List<CategoriaDTO> listCategorias(@RequestParam String codigo) {
        return categoriaServicio.listCategorias(codigo);
    }
}
