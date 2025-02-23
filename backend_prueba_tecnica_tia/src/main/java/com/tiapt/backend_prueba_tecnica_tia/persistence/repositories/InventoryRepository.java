package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByProductIdAndShopId(Long productId, Long shopId);
}
