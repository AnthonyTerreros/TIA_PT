package com.tiapt.backend_prueba_tecnica_tia.services.interfaces;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopAssignProductsRequestDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopDTO;

public interface InventoryService {
    void assignProductsToShop(ShopAssignProductsRequestDTO shopAssignProductsRequestDTO);
}
