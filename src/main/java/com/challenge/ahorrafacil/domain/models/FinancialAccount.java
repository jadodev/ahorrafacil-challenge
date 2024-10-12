package com.challenge.ahorrafacil.domain.models;

import java.time.LocalDateTime;

public class FinancialAccount {

    private Long accountId;

    private Long clientId;

    private Double totalAmount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public FinancialAccount(Long accountId, Long clientId, Double totalAmount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
