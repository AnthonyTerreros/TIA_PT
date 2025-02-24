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

    public ShopDTO(String name, Long id, String address, String contact, String phone, String openingTime, String closingTime) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.contact = contact;
        this.phone = phone;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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