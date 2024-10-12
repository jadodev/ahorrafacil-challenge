package com.challenge.ahorrafacil.infra.entities;

import com.challenge.ahorrafacil.domain.models.Product;
import jakarta.persistence.*;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "product_id")
    private Long productId;
    private String name;
    @Column(name = "product_type")
    private String productType;
    private String description;
    @Column(name = "average_yield")
    private Double averageYield;
    @Column(name = "minimum_amount")
    private Double minimumAmount;

    public ProductEntity() {
    }

    public ProductEntity(Long productId) {
        this.productId = productId;
    }

    public ProductEntity(Long productId, String name, String productType, String description, Double averageYield, Double minimumAmount) {
        this.productId = productId;
        this.name = name;
        this.productType = productType;
        this.description = description;
        this.averageYield = averageYield;
        this.minimumAmount = minimumAmount;
    }

    public static ProductEntity fromDomainModel(Product product) {
        return new ProductEntity(product.getProductId(), product.getName(), product.getProductType(), product.getDescription(), product.getAverageYield(), product.getMinimumAmount());
    }

    public Product toDomainModel() {
        return new Product(productId, name, productType, description, averageYield, minimumAmount);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAverageYield() {
        return averageYield;
    }

    public void setAverageYield(Double averageYield) {
        this.averageYield = averageYield;
    }

    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }
}
