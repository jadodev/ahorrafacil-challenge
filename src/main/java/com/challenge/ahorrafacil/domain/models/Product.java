package com.challenge.ahorrafacil.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String productType;
    private String description;
    private Double averageYield;
    private Double minimumAmount;

    public Product(Long productId, String name, String productType, String description, Double averageYield, Double minimumAmount) {
        this.productId = productId;
        this.name = name;
        this.productType = productType;
        this.description = description;
        this.averageYield = averageYield;
        this.minimumAmount = minimumAmount;
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
