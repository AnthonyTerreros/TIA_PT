package com.tiapt.backend_prueba_tecnica_tia.persistence.entities;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
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

    public SaleEntity() {

    }

    public SaleEntity(Long id, ShopEntity shop, UserEntity user, Double total, String paymentMethod, List<SaleDetailEntity> saleDetails, LocalDateTime purchaseDate) {
        this.id = id;
        this.shop = shop;
        this.user = user;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.saleDetails = saleDetails;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public List<SaleDetailEntity> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<SaleDetailEntity> saleDetails) {
        this.saleDetails = saleDetails;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
