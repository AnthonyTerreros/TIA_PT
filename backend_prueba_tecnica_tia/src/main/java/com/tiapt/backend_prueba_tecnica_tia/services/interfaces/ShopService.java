package com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopAssignProductsRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopDTO;

import java.util.List;

public interface ShopService {

    Page<ShopDTO> getAllShops(Pageable pageable);

    List<ShopDTO> getShops();

    ShopDTO createShop(ShopRequestDTO shopRequestDTO);
}