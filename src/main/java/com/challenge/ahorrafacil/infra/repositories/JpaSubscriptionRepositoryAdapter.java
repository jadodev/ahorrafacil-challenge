package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.domain.models.Subscription;
import com.challenge.ahorrafacil.domain.ports.out.SubscriptionRepositoryPort;
import com.challenge.ahorrafacil.infra.entities.SubscriptionEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaSubscriptionRepositoryAdapter implements SubscriptionRepositoryPort {

    private final JpaSubscriptionRepository subscriptionRepositoryJpa;

    public JpaSubscriptionRepositoryAdapter(JpaSubscriptionRepository subscriptionRepositoryJpa) {
        this.subscriptionRepositoryJpa = subscriptionRepositoryJpa;
    }

    @Override
    public Optional<Subscription> createSubscription(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = SubscriptionEntity.fromDomainModel(subscription);
        SubscriptionEntity savedSubscriptionEntity = subscriptionRepositoryJpa.save(subscriptionEntity);
        return Optional.of(savedSubscriptionEntity.toDomainModel());
    }

    @Override
    public Optional<Subscription> deactivateSubscription(Long id) {
        String newStatus = "inactive";
        Optional<SubscriptionEntity> subscriptionEntity = subscriptionRepositoryJpa.findById(id);
        if (subscriptionEntity.isPresent()) {
            subscriptionEntity.get().setStatus(newStatus);
            SubscriptionEntity savedSubscriptionEntity = subscriptionRepositoryJpa.save(subscriptionEntity.get());
            return Optional.of(savedSubscriptionEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public List<Subscription> getActiveSubscriptionsByClient(Long clientId) {
        List<SubscriptionEntity> subscriptionEntities = subscriptionRepositoryJpa.findByclientId(clientId);
        return subscriptionEntities.stream().map(SubscriptionEntity::toDomainModel).collect(Collectors.toList());
    }
}
