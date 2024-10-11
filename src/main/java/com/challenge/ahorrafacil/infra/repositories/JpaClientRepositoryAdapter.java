package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.domain.models.Client;
import com.challenge.ahorrafacil.domain.ports.out.ClientRepositoryPort;
import com.challenge.ahorrafacil.infra.entities.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaClientRepositoryAdapter implements ClientRepositoryPort {

    private final JpaClientRepository jpaClientRepository;

    public JpaClientRepositoryAdapter(JpaClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }
    @Override
    public Optional<Optional<Client>> updateClient(Client client) {
        if(!jpaClientRepository.existsById(client.getId())) {
            return Optional.empty();
        }
        ClientEntity clientEntity = ClientEntity.fromDomainModel(client);
        ClientEntity updatedClientEntity = jpaClientRepository.save(clientEntity);
        return Optional.of(Optional.of(updatedClientEntity.toDomainModel()));
    }

    @Override
    public Optional<Client> findClientByIdentification(String numIdentification) {
        return jpaClientRepository.findByNumIdentification(numIdentification)
                .map(ClientEntity::toDomainModel);
    }
}
