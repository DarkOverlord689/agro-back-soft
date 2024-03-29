package com.agrosoft.agrosoft.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.BancoEntities;

import jakarta.transaction.Transactional;

@Repository
public interface BancoRepository extends CrudRepository<BancoEntities, Long> {
    @Transactional
    @Modifying
    @Query(value = """
            update banco set estado = :estado where id = :id
                """, nativeQuery = true)
    void changeStatusBancos(@Param("id") Long id, @Param("estado") Long estado);
}
