package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleRequestDTO {
    @NotNull(message = "el id del usuario es requirido")
    public Long userId;

    @NotNull(message = "el id del usuario es requirido")
    public Long shopId;

    @NotNull(message = "total es requirido")
    private Double total;

    @NotNull(message = "metodo de pago es requirido")
    private String paymentMethod;

    public List<SaleDetailDTO> saleDTODetails;

    private LocalDateTime purchaseDate;
}