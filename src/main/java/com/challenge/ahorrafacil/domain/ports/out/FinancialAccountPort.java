package com.challenge.ahorrafacil.domain.ports.out;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;

import java.util.Optional;

public interface FinancialAccountPort {
    Optional<FinancialAccount> getAccountByClient(Long clientId);
    Optional<FinancialAccount> updateAccount(Long id, FinancialAccount financialAccount);

}
