package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.ShopDTO;
import com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private Long userId;

    private Long shopId;

    private ShopDTO shop;

    private UserDTO user;

    private Double total;

    private String paymentMethod;

    private List<SaleDetailDTO> saleDetails;

    private LocalDateTime purchaseDate;

    public SaleDTO() {

    }

    public SaleDTO(Long userId, List<SaleDetailDTO> saleDetails, String paymentMethod, Double total, UserDTO user, ShopDTO shop, Long shopId, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.saleDetails = saleDetails;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.user = user;
        this.shop = shop;
        this.shopId = shopId;
        this.purchaseDate = purchaseDate;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<SaleDetailDTO> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<SaleDetailDTO> saleDetails) {
        this.saleDetails = saleDetails;
    }
}