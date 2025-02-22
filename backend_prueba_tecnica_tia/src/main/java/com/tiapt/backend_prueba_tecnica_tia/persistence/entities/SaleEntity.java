package com.tiapt.backend_prueba_tecnica_tia.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "total")
    private String total;

    @Column(name = "payment_method")
    private String metodoPago;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<SaleDetailEntity> saleDetails;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @PrePersist
    protected void onCreate() {
        this.purchaseDate = LocalDateTime.now();
    }
}
