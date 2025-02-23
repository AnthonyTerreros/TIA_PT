package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private Long userId;

    private Long shopId;

    private Double total;

    private String paymentMethod;

    private List<SaleDetailDTO> saleDTODetails;

    private LocalDateTime purchaseDate;

    public SaleDTO() {

    }

    public SaleDTO(Long userId, String paymentMethod, Double total, Long shopId, List<SaleDetailDTO> saleDTODetails, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.shopId = shopId;
        this.saleDTODetails = saleDTODetails;
        this.purchaseDate = purchaseDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<SaleDetailDTO> getSaleDTODetails() {
        return saleDTODetails;
    }

    public void setSaleDTODetails(List<SaleDetailDTO> saleDTODetails) {
        this.saleDTODetails = saleDTODetails;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}