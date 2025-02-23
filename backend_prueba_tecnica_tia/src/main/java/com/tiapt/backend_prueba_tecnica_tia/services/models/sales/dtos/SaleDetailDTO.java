package com.tiapt.backend_prueba_tecnica_tia.services.models.sales.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaleDetailDTO {

    @NotNull(message = "El id del producto es requerida")
    public Long productId;

    @NotNull(message = "El id de la tienda es requerida")
    public Long shopId;

    @NotNull(message = "Cantidad es requerida")
    public Integer quantity;
}
