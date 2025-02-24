package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.NotFoundProductInShopException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.OutOfStockException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ProductNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.exception.exceptions.ShopNotFoundException;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.*;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.*;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.SaleService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleDetailDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos.SaleRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.sales.mappers.SaleMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final InventoryRepository inventoryRepository;
    private final SaleDetailRepository saleDetailRepository;
    private final UserRepository userRepository;

    public SaleServiceImpl(SaleMapper saleMapper, SaleRepository saleRepository, ProductRepository productRepository, ShopRepository shopRepository, InventoryRepository inventoryRepository, SaleDetailRepository saleDetailRepository, UserRepository userRepository) {
        this.saleMapper = saleMapper;
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.inventoryRepository = inventoryRepository;
        this.saleDetailRepository = saleDetailRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Page<SaleDTO> getAllSales(Pageable pageable) {
        return saleRepository.findAll(pageable).map(saleMapper::toDto);
    }

    @Transactional
    @Override
    public SaleDTO createSale(SaleRequestDTO saleRequestDTO) {
        SaleEntity saleEntity = saleMapper.toEntity(saleRequestDTO);

        ShopEntity shop = getShop(saleRequestDTO.getShopId());
        saleEntity.setShop(shop);

        SaleEntity finalSaleEntity = saleEntity;
        List<SaleDetailEntity> saleDetails = saleRequestDTO.getSaleDTODetails().stream()
                .map(detailDTO -> createSaleDetail(detailDTO, finalSaleEntity, shop))
                .collect(Collectors.toList());

        List<InventoryEntity> updatedInventory = saleDetails.stream()
                .map(detail -> updateInventoryStock(detail.getProduct().getId(), shop.getId(), detail.getQuantity()))
                .collect(Collectors.toList());

        double totalAmount = saleDetails.stream()
                .mapToDouble(detail -> detail.getProduct().getPrice() * detail.getQuantity())
                .sum();

        saleEntity.setTotal(totalAmount);
        UserEntity userEntity = getUser(saleRequestDTO.getUserId());
        saleEntity.setUser(userEntity);
        saleEntity = saleRepository.save(saleEntity);

        inventoryRepository.saveAll(updatedInventory);
        saleDetailRepository.saveAll(saleDetails);


        return saleMapper.toDto(saleEntity);
    }

    private ShopEntity getShop(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException(shopId));
    }

    private UserEntity getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No encontro usuario"));
    }

    private SaleDetailEntity createSaleDetail(SaleDetailDTO detailDTO, SaleEntity sale, ShopEntity shop) {
        ProductEntity product = productRepository.findById(detailDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(detailDTO.getProductId()));

        InventoryEntity inventory = inventoryRepository.findByProductIdAndShopId(product.getId(), shop.getId())
                .orElseThrow(() -> new NotFoundProductInShopException());

        if (inventory.getStock() < detailDTO.getQuantity()) {
            throw new OutOfStockException(product.getId());
        }

        SaleDetailEntity saleDetailEntity = new SaleDetailEntity();
        saleDetailEntity.setSale(sale);
        saleDetailEntity.setProduct(product);
        saleDetailEntity.setQuantity(detailDTO.getQuantity());
        return saleDetailEntity;
    }

    private InventoryEntity updateInventoryStock(Long productId, Long shopId, int quantity) {
        InventoryEntity inventory = inventoryRepository.findByProductIdAndShopId(productId, shopId)
                .orElseThrow(() -> new NotFoundProductInShopException());

        if (inventory.getStock() < quantity) {
            throw new OutOfStockException(productId);
        }

        inventory.setStock(inventory.getStock() - quantity);
        return inventory;
    }
}
