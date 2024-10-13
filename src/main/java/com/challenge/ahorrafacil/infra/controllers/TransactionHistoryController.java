package com.challenge.ahorrafacil.infra.controllers;

import com.challenge.ahorrafacil.application.services.TransactionHistoryService;
import com.challenge.ahorrafacil.infra.entities.TransactionHistoryEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction-history")
@CrossOrigin(origins = "*")
public class TransactionHistoryController {
    private final TransactionHistoryService transactionHistoryService;

    public TransactionHistoryController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionHistoryEntity>> getTransactionHistoryByClient(@PathVariable int id) {
        List<TransactionHistoryEntity> transactionHistory = transactionHistoryService.getTransactionHistoryByClient(id);
        return ResponseEntity.ok(transactionHistory);
    }



}
