package com.tiapt.backend_prueba_tecnica_tia.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sale_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "quantity")
    private Integer quantity;

}
