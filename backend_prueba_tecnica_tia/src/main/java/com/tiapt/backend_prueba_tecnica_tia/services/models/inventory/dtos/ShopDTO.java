package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

public class ShopDTO {
    private String name;

    private String address;

    private String contact;

    private String phone;

    private String openingTime;
    private String closingTime;

    public ShopDTO() {

    }

    public ShopDTO(String name, String address, String contact, String phone, String openingTime, String closingTime) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.phone = phone;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
}