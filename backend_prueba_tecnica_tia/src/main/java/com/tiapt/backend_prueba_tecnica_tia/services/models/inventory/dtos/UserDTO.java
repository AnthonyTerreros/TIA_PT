package com.tiapt.backend_prueba_tecnica_tia.services.models.inventory.dtos;

import jakarta.persistence.Column;

public class UserDTO {
    private Long id;

    private String names;

    private String phone;

    private String email;

    private String home_address;

    private String DNI;

    public UserDTO(Long id, String names, String phone, String email, String home_address, String DNI) {
        this.id = id;
        this.names = names;
        this.phone = phone;
        this.email = email;
        this.home_address = home_address;
        this.DNI = DNI;
    }

    public UserDTO() {

    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
