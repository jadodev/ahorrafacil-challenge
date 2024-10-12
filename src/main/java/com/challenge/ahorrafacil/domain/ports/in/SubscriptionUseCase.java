package com.challenge.ahorrafacil.domain.ports.in;

import com.challenge.ahorrafacil.domain.models.Subscription;

import java.util.Optional;

public interface SubscriptionUseCase {
    Optional<Subscription> createSubscription(Subscription subscription);
    Optional<Subscription> deactivateSubscription(Long id);
}
