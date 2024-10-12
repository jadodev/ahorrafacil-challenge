package com.challenge.ahorrafacil.infra.config;

import com.challenge.ahorrafacil.application.services.*;
import com.challenge.ahorrafacil.application.usecases.*;
import com.challenge.ahorrafacil.domain.ports.out.*;
import com.challenge.ahorrafacil.infra.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ClientService clientService(
            ClientRepositoryPort clientRepositoryPort) {
        return new ClientService(
                new UpdateClientUseCaseImpl(clientRepositoryPort),
                new FindClientUseCaseImplUseCaseImpl(clientRepositoryPort)
        );
    }

    @Bean
    public ClientRepositoryPort clientRepositoryPort(JpaClientRepositoryAdapter jpaClientRepositoryAdapter) {
        return jpaClientRepositoryAdapter;
    }

    @Bean
    public BranchesService branchesService(RetrieveBranchesPort retrieveBranchesPort) {
        return new BranchesService(new RetrieveBranchesUseCaseImpl(retrieveBranchesPort));
    }

    @Bean
    public RetrieveBranchesPort retrieveBranchesPort(JpaBranchRepositoryAdapter jpaBranchRepositoryAdapter) {
        return jpaBranchRepositoryAdapter;
    }

    @Bean
    public ProductService productService(RetrieveProductsRepositoryPort retrieveProductsRepositoryPort) {
        return new ProductService(new ProductsByBranchUseCaseImpl(retrieveProductsRepositoryPort));
    }

    @Bean
    public RetrieveProductsRepositoryPort retrieveProductsRepositoryPort(JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
        return jpaProductRepositoryAdapter;
    }

    @Bean
    public FinancialAccountService financialAccountService(FinancialAccountPort financialAccountPort) {
        return new FinancialAccountService(new GetFinancialAccountDetailsImpl(financialAccountPort));
    }

    @Bean
    public FinancialAccountPort financialAccountPort(JpaFinancialAccountRepositoryAdapter jpaFinancialAccountRepositoryAdapter) {
        return jpaFinancialAccountRepositoryAdapter;
    }

    @Bean
    public SubscriptionService subscriptionService(SubscriptionRepositoryPort subscriptionRepositoryPort, FinancialAccountPort financialAccountPort) {
        return new SubscriptionService(
                new CreateSubscriptionUseCaseImpl(subscriptionRepositoryPort),
                new GetFinancialAccountDetailsImpl(financialAccountPort)
        );
    }

    @Bean
    public SubscriptionRepositoryPort subscriptionRepositoryPort(JpaSubscriptionRepositoryAdapter jpaSubscriptionRepositoryAdapter) {
        return jpaSubscriptionRepositoryAdapter;
    }

}
