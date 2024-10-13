package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import com.challenge.ahorrafacil.domain.models.Subscription;
import com.challenge.ahorrafacil.domain.ports.in.FinancialAccountUseCase;
import com.challenge.ahorrafacil.domain.ports.in.SubscriptionUseCase;
import com.challenge.ahorrafacil.infra.entities.TransactionHistoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements SubscriptionUseCase {

    private final SubscriptionUseCase subscriptionUseCase;
    private final FinancialAccountUseCase financialAccountUseCase;
    private final TransactionHistoryService transactionHistoryService;

    public SubscriptionService(
            SubscriptionUseCase subscriptionUseCase,
            FinancialAccountUseCase financialAccountUseCase,
            TransactionHistoryService transactionHistoryService
            ) {
        this.subscriptionUseCase = subscriptionUseCase;
        this.financialAccountUseCase = financialAccountUseCase;
        this.transactionHistoryService = transactionHistoryService;
    }

    @Transactional
    public Optional<Subscription> createSubscription(Subscription subscription) {

        Optional<Subscription> savedSubscription =  subscriptionUseCase.createSubscription(subscription);
        Optional<FinancialAccount> financialAccountOpt = financialAccountUseCase.getAccountByClient(subscription.getClientId());

        if(financialAccountOpt.isPresent()) {
            FinancialAccount financialAcc = financialAccountOpt.get();
            financialAcc.setTotalAmount(financialAcc.getTotalAmount() - subscription.getSubscriptionAmount());
            financialAccountUseCase.updateAccount(financialAcc.getAccountId(), financialAcc);
            // Crear y guardar la transacción en DynamoDB
            TransactionHistoryEntity transaction = new TransactionHistoryEntity();
            transaction.setTransactionId(savedSubscription.get().getId().intValue());
            transaction.setClientId(subscription.getClientId().intValue());
            transaction.setProductId(subscription.getProductId().intValue());
            transaction.setTransactionType("subscription");
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setAmount(subscription.getSubscriptionAmount());
            transactionHistoryService.saveTransactionHistory(transaction);
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

    @Override
    public List<Subscription> getActiveSubscriptionsByClient(Long clientId) {
        return subscriptionUseCase.getActiveSubscriptionsByClient(clientId);
    }
}


