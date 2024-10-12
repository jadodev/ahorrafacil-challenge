package com.challenge.ahorrafacil.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class Subscription {
    private Long id;
    private Long productId;
    private Long clientId;
    private Double subscriptionAmount;
    private LocalDate subscriptionDate;
    private String status;

    public Subscription(Long id, Long productId, Long clientId, Double subscriptionAmount, LocalDate subscriptionDate, String status) {
        this.id = id;
        this.productId = productId;
        this.clientId = clientId;
        this.subscriptionAmount = subscriptionAmount;
        this.subscriptionDate = subscriptionDate;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(Double subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
