package com.challenge.ahorrafacil.domain.ports.in;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;

import java.util.Optional;

public interface FinancialAccountUseCase {
    Optional<FinancialAccount> getAccountByClient(Long clientId);
    Optional<FinancialAccount> updateAccount(Long id, FinancialAccount financialAccount);
}
