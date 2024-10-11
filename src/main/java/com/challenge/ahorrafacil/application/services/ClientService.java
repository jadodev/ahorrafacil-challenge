package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.domain.models.Client;
import com.challenge.ahorrafacil.domain.ports.in.FindUserByIdentificationUseCase;
import com.challenge.ahorrafacil.domain.ports.in.UpdateClientUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements FindUserByIdentificationUseCase, UpdateClientUseCase {

    private final UpdateClientUseCase updateClientUseCase;
    private final FindUserByIdentificationUseCase findClientUseCase;

    public ClientService(UpdateClientUseCase updateClientUseCase, FindUserByIdentificationUseCase findClientUseCase) {
        this.updateClientUseCase = updateClientUseCase;
        this.findClientUseCase = findClientUseCase;
    }
    @Override
    public Optional<Optional<Client>> updateClient(Long id, Client client) {
        return updateClientUseCase.updateClient(id, client);
    }

    @Override
    public Optional<Client> findClientByIdentification(String identification) {
        return findClientUseCase.findClientByIdentification(identification);
    }
}
