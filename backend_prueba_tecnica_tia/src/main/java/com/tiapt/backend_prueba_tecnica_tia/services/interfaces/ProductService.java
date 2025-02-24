package com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductRequestDTO;

public interface ProductService {

    Page<ProductDTO> getAllProducts(Pageable pageable);

    List<ProductDTO> getProducts();

    Optional<ProductDTO> getProductById(Long id);

    ProductDTO registerProduct(ProductRequestDTO productRequestDTO);

    List<ProductDTO> findAvailableProductsByShopId(Long shopId);
}
