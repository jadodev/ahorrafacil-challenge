package com.challenge.ahorrafacil.infra.entities;

import com.challenge.ahorrafacil.domain.models.Subscription;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Long subscriptionId;
    private Long productId;
    private Long clientId;
    @Column(name = "subscription_amount", nullable = false)
    private Double subscriptionAmount;
    @Column(name = "subscription_date", nullable = false)
    private LocalDate subscriptionDate;

    @Column(name = "status", nullable = false)
    private String status;

    public SubscriptionEntity() {
    }

    public SubscriptionEntity(Long subscriptionId, Long productId, Long clientId, Double subscriptionAmount, LocalDate subscriptionDate, String status) {
        this.subscriptionId = subscriptionId;
        this.productId = productId;
        this.clientId = clientId;
        this.subscriptionAmount = subscriptionAmount;
        this.subscriptionDate = subscriptionDate;
        this.status = status;
    }

    public static SubscriptionEntity fromDomainModel(Subscription subscription) {
        return new SubscriptionEntity(subscription.getId(), subscription.getProductId(), subscription.getClientId(), subscription.getSubscriptionAmount(), subscription.getSubscriptionDate(), subscription.getStatus());
    }

    public Subscription toDomainModel() {
        return new Subscription(
                subscriptionId,
                productId,
                clientId,
                subscriptionAmount,
                subscriptionDate,
                status
        );
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
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
