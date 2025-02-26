package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ProductDTO;
import jakarta.validation.constraints.NotNull;

public class SaleDetailDTO {

    @NotNull(message = "El id del producto es requerida")
    private Long productId;

    private ProductDTO product;

    @NotNull(message = "El id de la tienda es requerida")
    private Long saleId;

    @NotNull(message = "Cantidad es requerida")
    private Integer quantity;

    public SaleDetailDTO() {

    }

    public SaleDetailDTO(Long saleId, Long productId, ProductDTO product, Integer quantity) {
        this.saleId = saleId;
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
