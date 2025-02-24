package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

public class ShopDTO {

    private Long id;

    private String name;

    private String address;

    private String contact;

    private String phone;

    private String openingTime;
    private String closingTime;

    public ShopDTO() {

    }

    public ShopDTO(Long id, String name, String address, String contact, String phone, String openingTime, String closingTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.phone = phone;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}