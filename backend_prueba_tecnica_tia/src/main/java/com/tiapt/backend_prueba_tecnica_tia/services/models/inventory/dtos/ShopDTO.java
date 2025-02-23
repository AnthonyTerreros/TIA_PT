package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShopDTO {
    private String name;

    private String address;

    private String contact;

    private String phone;

    private String openingTime;
    private String closingTime;
}