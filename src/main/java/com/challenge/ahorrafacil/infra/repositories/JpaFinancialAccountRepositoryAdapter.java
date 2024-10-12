package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import com.challenge.ahorrafacil.domain.ports.out.FinancialAccountPort;
import com.challenge.ahorrafacil.infra.entities.FinancialAccountEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaFinancialAccountRepositoryAdapter implements FinancialAccountPort {
    private final JpaFinancialAccountRepository jpaFinancialAccountRepository;

    public JpaFinancialAccountRepositoryAdapter(JpaFinancialAccountRepository jpaFinancialAccountRepository) {
        this.jpaFinancialAccountRepository = jpaFinancialAccountRepository;
    }

    @Override
    public Optional<FinancialAccount> getAccountByClient(Long clientId) {
        return jpaFinancialAccountRepository.findByClientId(clientId).map(FinancialAccountEntity::toDomainModel);
    }

    @Override
    public Optional<FinancialAccount> updateAccount(Long id, FinancialAccount financialAccount) {
        if(!jpaFinancialAccountRepository.existsById(id)){
            return Optional.empty();
        }

        FinancialAccountEntity financialAccountEntity = FinancialAccountEntity.fromDomainModel(financialAccount);
        FinancialAccountEntity updatedFinancialAccountEntity = jpaFinancialAccountRepository.save(financialAccountEntity);
        return Optional.of(updatedFinancialAccountEntity.toDomainModel());

    }
}
