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

import com.agrosoft.agrosoft.model.ProveedoresDTO;
import com.agrosoft.agrosoft.service.ProveedoresServicio;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "api/v1/proveedores")
public class ProveedorController {

    @Autowired
    ProveedoresServicio proveedoresServicio;
    
    
    @GetMapping("/list")
    List<ProveedoresDTO> getProveedores() {
        return proveedoresServicio.listProveedores();
    }
    

    @PostMapping("/created-proveedor")
    void postProveedores(@RequestBody ProveedoresDTO proveedor) {
        proveedoresServicio.createdProveedores(proveedor);
    }

    @PutMapping("/update-status")
    void putStatusProveedores(@RequestParam Long proveedorId, @RequestParam Long estado) {
        proveedoresServicio.changeStatusProveedor(proveedorId, estado);
    }
}
