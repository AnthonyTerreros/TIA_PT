package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleDTO {

    public Long userId;

    public Long shopId;

    private Double total;

    private String paymentMethod;

    public List<SaleDetailDTO> saleDTODetails;

    private LocalDateTime purchaseDate;

}