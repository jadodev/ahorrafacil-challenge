package com.challenge.ahorrafacil.domain.ports.out;

import com.challenge.ahorrafacil.domain.models.Branch;

import java.util.List;

public interface RetrieveBranchesPort {
    List<Branch> findAll();
}
