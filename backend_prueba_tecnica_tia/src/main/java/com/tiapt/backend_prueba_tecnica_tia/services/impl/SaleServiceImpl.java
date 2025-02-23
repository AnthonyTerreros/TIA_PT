package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.OutOfStockException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ShopNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.*;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.InventoryRepository;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ProductRepository;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.SaleRepository;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ShopRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.SaleService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.SaleMapper;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDetailDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final InventoryRepository inventoryRepository;

    public SaleServiceImpl(SaleMapper saleMapper, SaleRepository saleRepository, ProductRepository productRepository, ShopRepository shopRepository, InventoryRepository inventoryRepository) {
        this.saleMapper = saleMapper;
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public Page<SaleDTO> getAllSales(Pageable pageable) {
        return saleRepository.findAll(pageable).map(saleMapper::toDto);
    }

    @Transactional
    @Override
    public SaleDTO createSale(SaleRequestDTO saleRequestDTO) {
        SaleEntity saleEntity = saleMapper.toEntity(saleRequestDTO);
        ShopEntity shop = shopRepository.findById(saleRequestDTO.getShopId())
                .orElseThrow(() -> new ShopNotFoundException(saleRequestDTO.getShopId()));

        saleEntity.setShop(shop);

        double totalAmount = 0.0;

        for (SaleDetailDTO detailDTO : saleRequestDTO.getSaleDTODetails()) {
            ProductEntity product = productRepository.findById(detailDTO.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(detailDTO.getProductId()));

            // Verificar stock en el inventario de la tienda
            InventoryEntity inventory = inventoryRepository.findByProductIdAndShopId(product.getId(), shop.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no disponible en esta tienda"));

            if (inventory.getStock() < detailDTO.getQuantity()) {
                throw new OutOfStockException(product.getId());
            }

            SaleDetailEntity saleDetail = SaleDetailEntity.builder()
                    .sale(saleEntity)
                    .product(product)
                    .quantity(detailDTO.getQuantity())
                    .build();

            totalAmount += product.getPrice() * detailDTO.getQuantity();

            // Reducir stock
            inventory.setStock(inventory.getStock() - detailDTO.getQuantity());
            inventoryRepository.save(inventory);

            saleEntity.getSaleDetails().add(saleDetail);
        }

        saleEntity.setTotal(totalAmount);
        saleEntity = saleRepository.save(saleEntity);
        return saleMapper.toDto(saleEntity);
    }
}
