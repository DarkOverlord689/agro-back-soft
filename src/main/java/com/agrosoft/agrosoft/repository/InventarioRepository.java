package com.agrosoft.agrosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.agrosoft.agrosoft.entities.InventarioEntities;

@Repository
public interface InventarioRepository extends CrudRepository<InventarioEntities, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE inventario SET estado = :estado WHERE id = :inventarioId", nativeQuery = true)
    void updateInventario(@Param("inventarioId") Long inventarioId, @Param("estado") Long estado);

    @Query(value = """
                select
                i.id,
                i.codigo,
                i.nombre,
                i.fk_categoria,
                i.fk_proveedor,
                i.fecha_inicial_ven,
                i.fecha_final_ven,
                i.costo_proveedor,
                i.cantidad_proveedor,
                i.valor_venta,
                i.descripcion,
                i.foto,
                i.estado,
                i.codigo_qr,
                i.created_at,
                i.updated_at
            from
                inventario i
            left join proveedores p on
                p.id = i.fk_proveedor
            where
                p.id = :proveedorId
                    """, nativeQuery = true)
    List<InventarioEntities> listInventarioProveedor(@Param("proveedorId") Long proveedorId);

    @Transactional
    @Modifying
    @Query(value = """
            update inventario set
            fecha_inicial_ven = :iniVen,
            fecha_final_ven = :finVen,
            costo_proveedor = :costoProveedor,
            cantidad_proveedor = :cantidadProveedor,
            valor_venta = :valor_venta
            where id = :idProveedor
                """, nativeQuery = true)
    void updateInventario(
            @Param("iniVen") String iniVen,
            @Param("finVen") String finVen,
            @Param("costoProveedor") Long costoProveedor,
            @Param("cantidadProveedor") Long cantidadProveedor,
            @Param("valor_venta") Long valor_venta,
            @Param("idProveedor") Long idProveedor);
}
