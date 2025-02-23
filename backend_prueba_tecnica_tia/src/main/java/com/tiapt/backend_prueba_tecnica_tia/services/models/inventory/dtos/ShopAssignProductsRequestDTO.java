package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ShopAssignProductsRequestDTO {

    private List<InventoryRequestDTO> inventoryRequestDTOList;

}
