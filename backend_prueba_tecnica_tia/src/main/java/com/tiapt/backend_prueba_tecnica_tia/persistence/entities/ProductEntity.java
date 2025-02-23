package com.tiapt.backend_prueba_tecnica_tia.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "SKU")
    private String SKU;

    @Column(name = "category")
    private String category;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "state")
    private Integer state = 1;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
