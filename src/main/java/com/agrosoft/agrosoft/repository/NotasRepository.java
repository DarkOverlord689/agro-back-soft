package com.agrosoft.agrosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.NotasEntities;

import jakarta.transaction.Transactional;

@Repository
public interface NotasRepository extends CrudRepository<NotasEntities, Long> {


    @Query(value = "select * from notas n where fk_user = :fk_user", nativeQuery = true)
    List<NotasEntities> listNotasByUser(@Param("fk_user") Long user);

    @Transactional
    @Modifying
    @Query(value = "update notas set estado = :estado where id = :id", nativeQuery = true)
    void updateNotasStatus(@Param("id") Long id, @Param("estado") Long estado);

    @Transactional
    @Modifying
    @Query(value = "update notas set descripcion = :descripcion where id = :id", nativeQuery = true)
    void updateNotasName(@Param("id") Long id, @Param("descripcion") String descripcion);

}
