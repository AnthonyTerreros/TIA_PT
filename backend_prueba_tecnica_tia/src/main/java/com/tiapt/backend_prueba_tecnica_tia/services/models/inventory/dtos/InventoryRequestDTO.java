package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class InventoryRequestDTO {

    @NotNull(message = "product_id es requerido")
    private Long productId;

    @NotNull(message = "shop_id es requerido")
    private Long shopId;

    @Min(value = 1, message = "El stock debe ser mayor a 0")
    private Long stock;

    public InventoryRequestDTO() {
    }

    public InventoryRequestDTO(Long shopId, Long stock, Long productId) {
        this.shopId = shopId;
        this.stock = stock;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
