package com.challenge.ahorrafacil.application.usecases;

import com.challenge.ahorrafacil.domain.models.Subscription;
import com.challenge.ahorrafacil.domain.ports.in.SubscriptionUseCase;
import com.challenge.ahorrafacil.domain.ports.out.SubscriptionRepositoryPort;

import java.util.Optional;

public class CreateSubscriptionUseCaseImpl implements SubscriptionUseCase {

    private final SubscriptionRepositoryPort subscriptionRepositoryPort;

    public CreateSubscriptionUseCaseImpl(SubscriptionRepositoryPort subscriptionRepositoryPort) {
        this.subscriptionRepositoryPort = subscriptionRepositoryPort;
    }

    @Override
    public Optional<Subscription> createSubscription(Subscription subscription) {
        return subscriptionRepositoryPort.createSubscription(subscription);
    }

    @Override
    public Optional<Subscription> deactivateSubscription(Long id) {
        return subscriptionRepositoryPort.deactivateSubscription(id);
    }
}
