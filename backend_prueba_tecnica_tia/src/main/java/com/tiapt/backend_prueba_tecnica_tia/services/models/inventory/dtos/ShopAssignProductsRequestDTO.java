package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import java.util.List;

public class ShopAssignProductsRequestDTO {

    private List<InventoryRequestDTO> inventoryRequestDTOList;

    public ShopAssignProductsRequestDTO() {

    }

    public ShopAssignProductsRequestDTO(List<InventoryRequestDTO> inventoryRequestDTOList) {
        this.inventoryRequestDTOList = inventoryRequestDTOList;
    }

    public List<InventoryRequestDTO> getInventoryRequestDTOList() {
        return inventoryRequestDTOList;
    }

    public void setInventoryRequestDTOList(List<InventoryRequestDTO> inventoryRequestDTOList) {
        this.inventoryRequestDTOList = inventoryRequestDTOList;
    }
}
