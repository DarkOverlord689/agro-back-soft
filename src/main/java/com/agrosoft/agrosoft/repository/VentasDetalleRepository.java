package com.agrosoft.agrosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agrosoft.agrosoft.entities.VentasDetalleEntities;
import com.agrosoft.agrosoft.model.VentasDetalleDTO;

@Repository
public interface VentasDetalleRepository extends CrudRepository<VentasDetalleEntities, Long> {

    @Query(value = """
            select * from detalle_ventas dv where fk_producto = :producto
                """, nativeQuery = true)
    List<VentasDetalleDTO> listVentasByProducto(@Param("producto") Long producto);
}
