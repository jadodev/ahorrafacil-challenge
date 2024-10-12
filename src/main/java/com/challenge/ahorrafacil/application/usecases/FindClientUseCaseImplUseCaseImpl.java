package com.challenge.ahorrafacil.application.usecases;

import com.challenge.ahorrafacil.domain.models.Client;
import com.challenge.ahorrafacil.domain.ports.in.FindUserByIdentificationUseCase;
import com.challenge.ahorrafacil.domain.ports.out.ClientRepositoryPort;

import java.util.Optional;

public class FindClientUseCaseImplUseCaseImpl implements FindUserByIdentificationUseCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public FindClientUseCaseImplUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> findClientByIdentification(String identification) {
        return clientRepositoryPort.findClientByIdentification(identification);
    }

}
