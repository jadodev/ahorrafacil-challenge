package com.challenge.ahorrafacil.infra.entities;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FinancialAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public FinancialAccountEntity() {
    }

    public FinancialAccountEntity(Long accountId, Long clientId, Double totalAmount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static FinancialAccountEntity fromDomainModel(FinancialAccount financialAccount) {
        return new FinancialAccountEntity(financialAccount.getAccountId(), financialAccount.getClientId(), financialAccount.getTotalAmount(), financialAccount.getCreatedAt(), financialAccount.getUpdatedAt());
    }

    public FinancialAccount toDomainModel() {
        return new FinancialAccount(accountId, clientId, totalAmount, createdAt, updatedAt);
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
