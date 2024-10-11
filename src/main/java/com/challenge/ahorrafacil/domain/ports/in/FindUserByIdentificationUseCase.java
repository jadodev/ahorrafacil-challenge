package com.challenge.ahorrafacil.domain.ports.in;

import com.challenge.ahorrafacil.domain.models.Client;

import java.util.Optional;

public interface FindUserByIdentificationUseCase {

    Optional<Client> findClientByIdentification(String identification);
}
