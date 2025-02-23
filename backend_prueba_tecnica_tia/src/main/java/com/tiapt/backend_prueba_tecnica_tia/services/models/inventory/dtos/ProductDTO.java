package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    private String name;

    private Double price;

    private String SKU;

    private String category;

    private String descripcion;

    private Integer state;
}
