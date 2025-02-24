package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

public class ProductDTO {

    private Long id;

    private String name;

    private Double price;

    private String SKU;

    private String category;

    private String description;

    private Integer state;

    public ProductDTO() {

    }

    public ProductDTO(String name, Integer state, Double price, String SKU, String category, String description, Long id) {
        this.name = name;
        this.state = state;
        this.price = price;
        this.SKU = SKU;
        this.category = category;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
