package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import com.challenge.ahorrafacil.domain.models.Subscription;
import com.challenge.ahorrafacil.domain.ports.in.FinancialAccountUseCase;
import com.challenge.ahorrafacil.domain.ports.in.SubscriptionUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SubscriptionService implements SubscriptionUseCase {

    private final SubscriptionUseCase subscriptionUseCase;
    private final FinancialAccountUseCase financialAccountUseCase;

    public SubscriptionService(SubscriptionUseCase subscriptionUseCase, FinancialAccountUseCase financialAccountUseCase) {
        this.subscriptionUseCase = subscriptionUseCase;
        this.financialAccountUseCase = financialAccountUseCase;
    }

    @Transactional
    public Optional<Subscription> createSubscription(Subscription subscription) {

        Optional<Subscription> savedSubscription =  subscriptionUseCase.createSubscription(subscription);
        Optional<FinancialAccount> financialAccountOpt = financialAccountUseCase.getAccountByClient(subscription.getClientId());

        if(financialAccountOpt.isPresent()) {
            FinancialAccount financialAcc = financialAccountOpt.get();
            financialAcc.setTotalAmount(financialAcc.getTotalAmount() - subscription.getSubscriptionAmount());
            financialAccountUseCase.updateAccount(financialAcc.getAccountId(), financialAcc);
        } else {
            throw new RuntimeException("Financial account not found for clientId: " + subscription.getClientId());
        }
        return Optional.of(savedSubscription.get());
    }

    @Transactional
    public Optional<Subscription> deactivateSubscription(Long id) {

        Optional<Subscription> subscriptionOpt = subscriptionUseCase.deactivateSubscription(id);
        if(subscriptionOpt.isPresent()) {
            Subscription subscription = subscriptionOpt.get();
            Optional<FinancialAccount> financialAccountOpt = financialAccountUseCase.getAccountByClient(subscription.getClientId());
            if(financialAccountOpt.isPresent()) {
                FinancialAccount financialAcc = financialAccountOpt.get();
                financialAcc.setTotalAmount(financialAcc.getTotalAmount() + subscription.getSubscriptionAmount());
                financialAccountUseCase.updateAccount(financialAcc.getAccountId(), financialAcc);
            } else {
                throw new RuntimeException("Financial account not found for clientId: " + subscription.getClientId());
            }
        } else {
            throw new RuntimeException("Subscription not found for id: " + id);
        }
        return subscriptionOpt;
    }
}


