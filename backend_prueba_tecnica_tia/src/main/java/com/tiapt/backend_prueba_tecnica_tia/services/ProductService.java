package com.tiapt.backend_prueba_tecnica_tia.services;

import com.tiapt.backend_prueba_tecnica_tia.services.models.dtos.inventory.ProductDTO;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ProductService {

    Optional<ProductDTO> getProduct(Pageable pageable);

    void registerProduct(ProductDTO productDTO);


}
