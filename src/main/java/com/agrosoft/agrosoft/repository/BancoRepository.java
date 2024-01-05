package com.agrosoft.agrosoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.BancoEntities;

@Repository
public interface BancoRepository extends CrudRepository<BancoEntities, Long>{
    
}
