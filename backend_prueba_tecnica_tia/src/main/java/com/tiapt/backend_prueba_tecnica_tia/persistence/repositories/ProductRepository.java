package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findBySKU(String SKU);

    Page<ProductEntity> findAll(Pageable pageable);

    @Query(value = "SELECT DISTINCT p.* FROM products p " +
            "INNER JOIN products_shops_inventory i ON p.id = i.product_id " +
            "WHERE i.shop_id = :shopId AND i.stock > 0",
            nativeQuery = true)
    List<ProductEntity> findAvailableProductsByShopId(@Param("shopId") Long shopId);
}
