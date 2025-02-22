package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ProductRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.ProductService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.ProductMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        Page<ProductDTO> productDtoPage = productRepository.findAll(pageable)
                .map(productMapper::toDto);
        return productDtoPage;

    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    @Override
    public ProductDTO registerProduct(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productMapper.toEntity(productRequestDTO);
        productEntity = productRepository.save(productEntity);
        return productMapper.toDto(productEntity);
    }

}
