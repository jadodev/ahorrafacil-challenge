package com.challenge.ahorrafacil.infra.config;

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


}
