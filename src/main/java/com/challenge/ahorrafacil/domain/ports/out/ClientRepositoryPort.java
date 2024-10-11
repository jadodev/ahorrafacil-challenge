package com.challenge.ahorrafacil.domain.ports.out;

import com.challenge.ahorrafacil.domain.models.Client;

import java.util.Optional;

public interface ClientRepositoryPort {

    Optional<Optional<Client>> updateClient(Client client);
    Optional<Client> findClientByIdentification(String identification);

}
