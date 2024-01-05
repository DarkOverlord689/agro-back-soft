package com.agrosoft.agrosoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.FechasEspecialesEntities;

@Repository
public interface FechasEspecialesRepository extends CrudRepository<FechasEspecialesEntities, Long> {
}
