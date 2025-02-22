package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.services.ProductService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.dtos.inventory.ProductDTO;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Optional<ProductDTO> getProduct(Pageable pageable) {
        return Optional.empty();
    }

    @Override
    public void registerProduct(ProductDTO productDTO) {
    
    }
}
