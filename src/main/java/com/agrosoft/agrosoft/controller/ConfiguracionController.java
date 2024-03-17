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

import com.agrosoft.agrosoft.model.BancosDTO;
import com.agrosoft.agrosoft.model.CategoriaDTO;
import com.agrosoft.agrosoft.model.CategoriaMaestraDTO;
import com.agrosoft.agrosoft.model.TiposDTO;
import com.agrosoft.agrosoft.model.TiposMaestrosDTO;
import com.agrosoft.agrosoft.service.BancoServicio;
import com.agrosoft.agrosoft.service.CategoriaServicio;
import com.agrosoft.agrosoft.service.TiposServicio;

@RestController
@CrossOrigin(originPatterns = "*")
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

    @GetMapping("/list-categorias-maestros")
    List<CategoriaMaestraDTO> listCategoriasMaestras() {
        return categoriaServicio.listCategoriasMaestra();
    }

    @GetMapping("/list-tipos-maestros")
    List<TiposMaestrosDTO> listTiposMaestras() {
        return tiposServicio.listTiposMaestra();
    }

    @PostMapping("/created-tipos-maestros")
    void postTiposMaestros(@RequestBody TiposMaestrosDTO tiposMaestrosDTO) {
        tiposServicio.createdTiposMaestras(tiposMaestrosDTO);
    }

    @PostMapping("/created-categoria-maestros")
    void postCategoriaMaestros(@RequestBody CategoriaMaestraDTO categoriaMaestraDTO) {
        categoriaServicio.createdCategoriaMaestras(categoriaMaestraDTO);
    }

    @PostMapping("/created-tipos")
    void postTipos(@RequestBody TiposDTO tiposDTO) {
        tiposServicio.createdTipos(tiposDTO);
    }

    @PostMapping("/created-categorias")
    void postCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaServicio.createdCategoria(categoriaDTO);
    }

    @PutMapping("/change-status-tipos")
    void putChangeStatusTipos(@RequestParam Long idTipo, @RequestParam Long estado) {
        tiposServicio.changeStatusTipos(idTipo, estado);
    }

    @PutMapping("/change-status-categoria")
    void putChangeStatusCategoria(@RequestParam Long idCategoria, @RequestParam Long estado) {
        categoriaServicio.changeStatusCategoria(idCategoria, estado);
    }

    @PutMapping("/change-status-bancos")
    void putChangeStatusBancos(@RequestParam Long id, @RequestParam Long estado) {
        bancoServicio.changeStatusBancos(id, estado);
    }
}
