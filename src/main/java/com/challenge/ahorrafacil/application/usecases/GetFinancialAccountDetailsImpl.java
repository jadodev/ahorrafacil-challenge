package com.challenge.ahorrafacil.application.usecases;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import com.challenge.ahorrafacil.domain.ports.in.FinancialAccountUseCase;
import com.challenge.ahorrafacil.domain.ports.out.FinancialAccountPort;

import java.util.Optional;

public class GetFinancialAccountDetailsImpl implements FinancialAccountUseCase {
    private final FinancialAccountPort financialAccountPort;

    public GetFinancialAccountDetailsImpl(FinancialAccountPort financialAccountPort) {
        this.financialAccountPort = financialAccountPort;
    }

    @Override
    public Optional<FinancialAccount> getAccountByClient(Long clientId) {
        return financialAccountPort.getAccountByClient(clientId);
    }

    @Override
    public Optional<FinancialAccount> updateAccount(Long id, FinancialAccount financialAccount) {
        return financialAccountPort.updateAccount(id, financialAccount);
    }
}
