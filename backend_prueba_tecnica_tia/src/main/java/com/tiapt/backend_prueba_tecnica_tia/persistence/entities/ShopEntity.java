package com.tiapt.backend_prueba_tecnica_tia.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "opening_time")
    private String openingTime;

    @Column(name = "closing_time")
    private String closingTime;

}
