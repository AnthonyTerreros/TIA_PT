package com.tiapt.backend_prueba_tecnica_tia.services.impl;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.SaleEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.ShopEntity;
import com.tiapt.backend_prueba_tecnica_tia.persistence.repositories.ShopRepository;
import com.tiapt.backend_prueba_tecnica_tia.services.interfaces.ShopService;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopAssignProductsRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.mappers.ShopMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopMapper shopMapper, ShopRepository shopRepository)  {
        this.shopMapper = shopMapper;
        this.shopRepository = shopRepository;
    }

    @Override
    public Page<ShopDTO> getAllShops(Pageable pageable) {
        return shopRepository.findAll(pageable).map(shopMapper::toDto);
    }

    @Override
    public List<ShopDTO> getShops() {
        return shopRepository.findAll().stream().map(shopMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ShopDTO createShop(ShopRequestDTO shopRequestDTO) {
        ShopEntity shopEntity = shopMapper.toEntity(shopRequestDTO);
        shopEntity = shopRepository.save(shopEntity);
        return shopMapper.toDto(shopEntity);
    }

}
