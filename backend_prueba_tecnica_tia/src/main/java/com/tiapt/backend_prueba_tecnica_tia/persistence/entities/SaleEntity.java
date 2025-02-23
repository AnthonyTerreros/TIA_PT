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

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @Column(name = "total")
    private Double total;

    @Column(name = "payment_method")
    private String paymentMethod = "cash";

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleDetailEntity> saleDetails;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @PrePersist
    protected void onCreate() {
        this.purchaseDate = LocalDateTime.now();
    }
}
