package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Long, InventoryEntity> {
}
