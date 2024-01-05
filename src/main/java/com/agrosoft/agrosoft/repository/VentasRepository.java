package com.agrosoft.agrosoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.VentasEntities;

@Repository
public interface VentasRepository extends CrudRepository<VentasEntities, Long>{
    
}
