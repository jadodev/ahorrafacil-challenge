package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.infra.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    List<SubscriptionEntity> findByclientId(Long clientId);

}


