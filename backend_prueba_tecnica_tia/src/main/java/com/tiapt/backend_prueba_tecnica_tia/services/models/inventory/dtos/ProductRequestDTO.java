package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotNull(message = "Nombre es requido")
    private String name;

    @NotNull(message = "Precio es requido")
    private Double price;

    @NotNull(message = "SKU es requido")
    private String SKU;

    @NotNull(message = "Categoria es requido")
    private String category;

    private String description;
    private Integer state;

}
