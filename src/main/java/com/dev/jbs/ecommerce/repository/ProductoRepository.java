package com.dev.jbs.ecommerce.repository;

import com.dev.jbs.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByEstado(boolean estado);

    @Modifying
    @Transactional
    @Query("UPDATE Producto p SET p.estado = false WHERE p.id = :id")
    int deactivateProducto(@Param("id") Long id);

}
