package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ShopNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.InventoryEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ProductEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ShopEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.InventoryRepository;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ProductRepository;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ShopRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.InventoryService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.InventoryRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopAssignProductsRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl  implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final ShopRepository shopRepository;

    private final ProductRepository productRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, ShopRepository shopRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public void assignProductsToShop(ShopAssignProductsRequestDTO shopAssignProductsRequestDTO) {
        List<InventoryEntity> inventoryToSave = new ArrayList<>();
        for (InventoryRequestDTO request : shopAssignProductsRequestDTO.getInventoryRequestDTOList()) {
            ProductEntity product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(request.getProductId()));

            ShopEntity shop = shopRepository.findById(request.getShopId())
                    .orElseThrow(() -> new ShopNotFoundException(request.getShopId()));

            InventoryEntity inventory = inventoryRepository.findByProductIdAndShopId(product.getId(), shop.getId())
                    .orElseGet(InventoryEntity::new);

            inventory.setProduct(product);
            inventory.setShop(shop);
            inventory.setStock(request.getStock() + inventory.getStock());
            inventoryToSave.add(inventory);
        }
        inventoryRepository.saveAll(inventoryToSave);
    }
}
