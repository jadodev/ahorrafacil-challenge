package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.domain.models.Branch;
import com.challenge.ahorrafacil.domain.ports.in.RetrieveBranchesUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchesService implements RetrieveBranchesUseCase {
    private final RetrieveBranchesUseCase retrieveBranchesUseCase;

    public BranchesService(RetrieveBranchesUseCase retrieveBranchesUseCase) {
        this.retrieveBranchesUseCase = retrieveBranchesUseCase;
    }

    @Override
    public List<Branch> getAllBranches() {
        return retrieveBranchesUseCase.getAllBranches();
    }

}
