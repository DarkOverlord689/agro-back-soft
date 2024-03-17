package com.agrosoft.agrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.service.FechasEspecialesServicio;
import com.agrosoft.agrosoft.model.FechasEspecialesDTO;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "/api/v1/fechas-especiales")
public class FechasEspecialesController {

    @Autowired
    FechasEspecialesServicio fechasEspecialesServicio;

    @RequestMapping("/list")
    List<FechasEspecialesDTO> listFechasEspeciales() {
        return fechasEspecialesServicio.listFechasEspeciales();
    }

    @RequestMapping("/created-fecha-especial")
    void createdFechasEspeciales(@RequestBody FechasEspecialesDTO fechasEspecialesDTO) {
        fechasEspecialesServicio.createdFechasEspeciales(fechasEspecialesDTO);
    }
}
