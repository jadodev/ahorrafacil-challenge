package com.challenge.ahorrafacil.infra.controllers;

import com.challenge.ahorrafacil.application.services.FinancialAccountService;
import com.challenge.ahorrafacil.domain.models.FinancialAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/financial-account")
@CrossOrigin(origins = "*")
public class FinancialAccountController {

    private final FinancialAccountService financialAccountService;

    public FinancialAccountController(FinancialAccountService financialAccountService) {
        this.financialAccountService = financialAccountService;
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<FinancialAccount> getAccountByClient(@PathVariable Long clientId) {
        Optional<FinancialAccount> result = financialAccountService.getAccountByClient(clientId);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
