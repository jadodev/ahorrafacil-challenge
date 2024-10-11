package com.challenge.ahorrafacil.application.usecases;

import com.challenge.ahorrafacil.domain.models.Client;
import com.challenge.ahorrafacil.domain.ports.in.UpdateClientUseCase;
import com.challenge.ahorrafacil.domain.ports.out.ClientRepositoryPort;

import java.util.Optional;

public class UpdateClientUseCaseImpl  implements UpdateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public UpdateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }
    @Override
    public Optional<Optional<Client>> updateClient(Long id, Client client) {
        return clientRepositoryPort.updateClient(client);
    }

}
