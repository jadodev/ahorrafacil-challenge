package com.challenge.ahorrafacil.domain.ports.in;

import com.challenge.ahorrafacil.domain.models.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionUseCase {

    List<Subscription> getActiveSubscriptionsByClient(Long clientId);
    Optional<Subscription> createSubscription(Subscription subscription);
    Optional<Subscription> deactivateSubscription(Long id);
}
