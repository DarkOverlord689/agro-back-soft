package com.agrosoft.agrosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.TiposEntities;

import jakarta.transaction.Transactional;

@Repository
public interface TiposRepository extends CrudRepository<TiposEntities, Long> {

    @Query(value = """
            select t.id, t.codigo, t.nombre, t.estado, t.fk_tipo_maestros, t.created_at, t.updated_at
            from tipos t
            left join tipo_maestros tm ON tm.id = t.fk_tipo_maestros
            where tm.codigo = :codigo
                """, nativeQuery = true)
    List<TiposEntities> listTipos(@Param("codigo") String codigo);

    @Transactional
    @Modifying
    @Query(value = """
            update tipos set estado = :estado where id = :id
                """, nativeQuery = true)
    void changeStatus(@Param("id") Long id, @Param("estado") Long estado);
}
