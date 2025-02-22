package com.tiapt.backend_prueba_tecnica_tia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductRequestDTO;

public interface ProductService {

    Page<ProductDTO> getAllProducts(Pageable pageable);

    Optional<ProductDTO> getProductById(Long id);

    ProductDTO registerProduct(ProductRequestDTO productRequestDTO);

}
