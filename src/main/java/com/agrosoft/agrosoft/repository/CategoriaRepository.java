package com.agrosoft.agrosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.CategoriaEntities;

import jakarta.transaction.Transactional;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntities, Long> {

    @Query(value = """
            select c.id, c.codigo, c.nombre, c.fk_categoria_maestra , c.estado,c.created_at, c.updated_at
            from categoria c
            left join categoria_maestra cm ON cm.id = c.fk_categoria_maestra
            where cm.codigo = :codigo
                """, nativeQuery = true)
    List<CategoriaEntities> listCategorias(@Param("codigo") String codigo);

    @Transactional
    @Modifying
    @Query(value = """
            update categoria set estado = :estado where id = :id
                """, nativeQuery = true)
    void changeStatus(@Param("id") Long id, @Param("estado") Long estado);
}
