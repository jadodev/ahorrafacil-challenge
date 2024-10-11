package com.challenge.ahorrafacil.application.usecases;

import com.challenge.ahorrafacil.domain.models.Branch;
import com.challenge.ahorrafacil.domain.ports.in.RetrieveBranchesUseCase;
import com.challenge.ahorrafacil.domain.ports.out.RetrieveBranchesPort;

import java.util.List;

public class RetrieveBranchesUseCaseImpl implements RetrieveBranchesUseCase {
    private final RetrieveBranchesPort retrieveBranchesPort;

    public RetrieveBranchesUseCaseImpl(RetrieveBranchesPort retrieveBranchesPort) {
        this.retrieveBranchesPort = retrieveBranchesPort;
    }

    @Override
    public List<Branch> getAllBranches() {
        return retrieveBranchesPort.findAll();
    }
}
