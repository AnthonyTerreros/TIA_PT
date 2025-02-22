package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Long, ProductEntity> {
}
