package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryRequestDTO {

    @NotNull(message = "product_id es requerido")
    private Long productId;

    @NotNull(message = "shop_id es requerido")
    private Long shopId;

    @Min(value = 1, message = "El stock debe ser mayor a 0")
    private Long stock;
}
