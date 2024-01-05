package com.agrosoft.agrosoft.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.agrosoft.agrosoft.entities.ProveedoresEntities;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedoresEntities, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE proveedores SET estado = :estado WHERE id = :proveedorId", nativeQuery = true)
    void updateProveedor(@Param("proveedorId") Long proveedorId, @Param("estado") Long estado);
}
