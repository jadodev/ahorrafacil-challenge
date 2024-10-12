package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.infra.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

}


