package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import com.challenge.ahorrafacil.domain.ports.in.FinancialAccountUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinancialAccountService implements FinancialAccountUseCase {
    private final FinancialAccountUseCase financialAccountUseCase;

    public FinancialAccountService(FinancialAccountUseCase financialAccountUseCase) {
        this.financialAccountUseCase = financialAccountUseCase;
    }

    @Override
    public Optional<FinancialAccount> getAccountByClient(Long clientId) {
        return financialAccountUseCase.getAccountByClient(clientId);
    }

    @Override
    public Optional<FinancialAccount> updateAccount(Long id, FinancialAccount financialAccount) {
        return financialAccountUseCase.updateAccount(id, financialAccount);
    }
}
