package com.tiapt.backend_prueba_tecnica_tia.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products_shops_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @Column(name = "stock")
    private Long stock;
}
