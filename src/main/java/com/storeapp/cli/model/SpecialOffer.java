package com.storeapp.cli.model;

import jakarta.persistence.*;

@Entity
@Table(name = "specialoffers")
public class SpecialOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long specialOfferId;

    @Column(nullable = false)
    private String sku;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "spec_Price", nullable = false)
    private Double specPrice;

    @Column(name = "spec_Desc")
    private String specDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false) // links to products.id
    private Product product;

    // Constructors
    public SpecialOffer() {}

    // Getters and Setters
    public Long getSpecialOfferId() {
        return specialOfferId;
    }

    public void setSpecialOfferId(Long specialOfferId) {
        this.specialOfferId = specialOfferId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(Double specPrice) {
        this.specPrice = specPrice;
    }

    public String getSpecDescription() {
        return specDescription;
    }

    public void setSpecDescription(String specDescription) {
        this.specDescription = specDescription;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "SpecialOffer [id=" + specialOfferId +
                ", sku=" + sku +
                ", quantity=" + quantity +
                ", specPrice=" + specPrice +
                ", description=" + specDescription +
                ", product=" + (product != null ? product.getName() : "null") +
                "]";
    }
}