package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class SaleRequestDTO {
    @NotNull(message = "el id del usuario es requirido")
    private Long userId;

    @NotNull(message = "el id del usuario es requirido")
    private Long shopId;

    @NotNull(message = "total es requirido")
    private Double total;

    @NotNull(message = "metodo de pago es requirido")
    private String paymentMethod;

    private List<SaleDetailDTO> saleDTODetails;

    private LocalDateTime purchaseDate;

    public SaleRequestDTO() {

    }

    public SaleRequestDTO(Long userId, Long shopId, Double total, String paymentMethod, List<SaleDetailDTO> saleDTODetails, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.shopId = shopId;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.saleDTODetails = saleDTODetails;
        this.purchaseDate = purchaseDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
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