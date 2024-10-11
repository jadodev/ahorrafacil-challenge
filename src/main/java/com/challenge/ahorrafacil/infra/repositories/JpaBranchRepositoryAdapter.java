package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.domain.models.Branch;
import com.challenge.ahorrafacil.domain.ports.out.RetrieveBranchesPort;
import com.challenge.ahorrafacil.infra.entities.BranchEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaBranchRepositoryAdapter implements RetrieveBranchesPort {
    private final JpaBranchRepository jpaBranchRepository;

    public JpaBranchRepositoryAdapter(JpaBranchRepository jpaBranchRepository) {
        this.jpaBranchRepository = jpaBranchRepository;
    }

    @Override
    public List<Branch> findAll() {
        return jpaBranchRepository.findAll().stream().map(BranchEntity::toDomainModel).collect(Collectors.toList());
    }

}
