package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShopRequestDTO {

    @NotNull(message = "Nombre es requido")
    private String name;

    @NotNull(message = "Address es requido")
    private String address;

    @NotNull(message = "Contacto es requido")
    private String contact;

    @NotNull(message = "Telefono es requido")
    private String phone;

    private String openingTime;
    private String closingTime;

}