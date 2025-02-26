package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryRequestDTO {

    @NotNull(message = "Nombre es requerido")
    @NotBlank(message = "Nombre no debe estar vacio.")
    @Min(value = 4, message = "Debe tener al menos 4 caracteres")
    private String name;

    private String description;

    public CategoryRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryRequestDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
