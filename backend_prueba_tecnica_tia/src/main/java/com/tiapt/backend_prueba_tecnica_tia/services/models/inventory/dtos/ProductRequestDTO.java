package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.NotNull;

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


    public ProductRequestDTO() {

    }

    public ProductRequestDTO(String name, Integer state, String description, String category, String SKU, Double price) {
        this.name = name;
        this.state = state;
        this.description = description;
        this.category = category;
        this.SKU = SKU;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
