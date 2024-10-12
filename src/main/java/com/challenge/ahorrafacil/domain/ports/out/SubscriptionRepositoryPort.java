package com.challenge.ahorrafacil.domain.ports.out;

import com.challenge.ahorrafacil.domain.models.Subscription;

import java.util.Optional;

public interface SubscriptionRepositoryPort {
    Optional<Subscription> createSubscription(Subscription subscription);
    Optional<Subscription> deactivateSubscription(Long id);

}
