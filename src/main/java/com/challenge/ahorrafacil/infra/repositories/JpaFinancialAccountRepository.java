package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.infra.entities.FinancialAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaFinancialAccountRepository extends JpaRepository<FinancialAccountEntity, Long> {
    Optional<FinancialAccountEntity> findByClientId(Long clientId);

}
