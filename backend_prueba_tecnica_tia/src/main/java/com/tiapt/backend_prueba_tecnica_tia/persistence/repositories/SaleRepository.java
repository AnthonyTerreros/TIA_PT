package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Long, SaleEntity> {
}
