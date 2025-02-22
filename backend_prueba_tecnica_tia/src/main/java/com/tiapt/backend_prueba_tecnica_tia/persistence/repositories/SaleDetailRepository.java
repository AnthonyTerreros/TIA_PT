package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDetailRepository extends JpaRepository<Long, SaleDetailEntity> {
}
