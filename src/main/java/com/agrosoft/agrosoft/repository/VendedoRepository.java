package com.agrosoft.agrosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.VendedorEntities;

import jakarta.transaction.Transactional;

@Repository
public interface VendedoRepository extends CrudRepository<VendedorEntities, Long> {

    Optional<VendedorEntities> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = """
            update vendedor
            SET token = :token
            WHERE username = :username
                """, nativeQuery = true)
    void updateToken(@Param("token") String token, @Param("username") String username);

    @Query(value = "select token from vendedor v where username = :username", nativeQuery = true)
    String tokenByUser(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = """
        update vendedor set estado = :estado where id = :id
            """, nativeQuery = true)
    void changeStatusVendedor(@Param("estado") Long estado, @Param("id") Long id);
}
