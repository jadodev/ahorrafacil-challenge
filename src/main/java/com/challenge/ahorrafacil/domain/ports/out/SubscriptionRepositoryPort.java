package com.challenge.ahorrafacil.domain.ports.out;

import com.challenge.ahorrafacil.domain.models.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepositoryPort {

    List<Subscription> getActiveSubscriptionsByClient(Long clientId);
    Optional<Subscription> createSubscription(Subscription subscription);
    Optional<Subscription> deactivateSubscription(Long id);

}
