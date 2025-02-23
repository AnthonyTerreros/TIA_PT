package com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopAssignProductsRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopDTO;

public interface ShopService {

    Page<ShopDTO> getAllShops(Pageable pageable);

    ShopDTO createShop(ShopRequestDTO shopRequestDTO);
}