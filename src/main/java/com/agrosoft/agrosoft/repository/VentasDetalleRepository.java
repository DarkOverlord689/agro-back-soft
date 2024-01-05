package com.agrosoft.agrosoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.VentasDetalleEntities;

@Repository
public interface VentasDetalleRepository extends CrudRepository<VentasDetalleEntities, Long> {

}
