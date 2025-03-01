package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductDuplicatedSKUException;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ProductRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.ProductService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.ProductMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return productRepository.findAll(pageable)
                .map(productMapper::toDto);
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    @Override
    public ProductDTO registerProduct(ProductRequestDTO productRequestDTO) {
        Optional<ProductEntity> productEntityExists = productRepository.findBySKU(productRequestDTO.getSKU());
        if (productEntityExists.isPresent()) {
            throw new ProductDuplicatedSKUException(productEntityExists.get().getId());
        }
        ProductEntity productEntity = productMapper.toEntity(productRequestDTO);
        productEntity = productRepository.save(productEntity);
        return productMapper.toDto(productEntity);
    }

    @Override
    public List<ProductDTO> findAvailableProductsByShopId(Long shopId) {
        return productRepository.findAvailableProductsByShopId(shopId).stream().map(productMapper::toDto)
                .collect(Collectors.toList());
    }

}
