package com.agrosoft.agrosoft.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.UsuariosEntities;

import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuariosEntities, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuarios SET estado = :estado WHERE id = :userId", nativeQuery = true)
    void updateUser(@Param("userId") Long userId, @Param("estado") Long estado);
}
