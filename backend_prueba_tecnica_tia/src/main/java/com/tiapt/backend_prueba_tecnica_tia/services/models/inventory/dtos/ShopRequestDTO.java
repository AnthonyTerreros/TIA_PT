package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.validation.constraints.NotNull;

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

    public ShopRequestDTO() {

    }

    public ShopRequestDTO(String name, String openingTime, String phone, String contact, String address, String closingTime) {
        this.name = name;
        this.openingTime = openingTime;
        this.phone = phone;
        this.contact = contact;
        this.address = address;
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }
}