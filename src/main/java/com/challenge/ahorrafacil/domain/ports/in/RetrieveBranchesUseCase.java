package com.challenge.ahorrafacil.domain.ports.in;

import com.challenge.ahorrafacil.domain.models.Branch;

import java.util.List;

public interface RetrieveBranchesUseCase {
    List<Branch> getAllBranches();
}
