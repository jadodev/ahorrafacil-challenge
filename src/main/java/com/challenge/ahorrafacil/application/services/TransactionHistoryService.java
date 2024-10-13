package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.infra.entities.TransactionHistoryEntity;
import com.challenge.ahorrafacil.infra.repositories.TransactionHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHistoryService {
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public void saveTransactionHistory(TransactionHistoryEntity transaction) {
        transactionHistoryRepository.save(transaction);
    }

    public List<TransactionHistoryEntity> getTransactionHistoryByClient(int clientId) {
        return transactionHistoryRepository.findByClientId(clientId);
    }

}
