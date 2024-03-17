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

import com.agrosoft.agrosoft.model.VendedorDTO;
import com.agrosoft.agrosoft.service.VendedorService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "api/v1/vendedor")
public class VendedorController {

    @Autowired
    VendedorService vendedorService;

    @GetMapping("list")
    List<VendedorDTO> listVendedores() {
        return vendedorService.listVendedores();
    };

    @PostMapping("created-vendedor")
    void createdVendedores(@RequestBody VendedorDTO vendedorDTO) {
        vendedorService.createdVendedores(vendedorDTO);
    };

    @PutMapping("change-status")
    void changeStatusVendedor(@RequestParam Long id, @RequestParam Long estado) {
        vendedorService.changeStatusVendedor(estado, id);
    }
}
