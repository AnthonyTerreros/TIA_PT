package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import jakarta.validation.constraints.NotNull;

public class SaleDetailDTO {

    @NotNull(message = "El id del producto es requerida")
    private Long productId;

    @NotNull(message = "El id de la tienda es requerida")
    private Long shopId;

    @NotNull(message = "Cantidad es requerida")
    private Integer quantity;

    public SaleDetailDTO() {

    }

    public SaleDetailDTO(Long productId, Integer quantity, Long shopId) {
        this.productId = productId;
        this.quantity = quantity;
        this.shopId = shopId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
