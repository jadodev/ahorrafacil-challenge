package com.challenge.ahorrafacil.infra.controllers;

import com.challenge.ahorrafacil.application.services.BranchesService;
import com.challenge.ahorrafacil.domain.models.Branch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branch")
@CrossOrigin(origins = "*")
public class BranchController {

    private final BranchesService branchService;

    public BranchController(BranchesService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Branch>> findAll() {
        List<Branch> result = branchService.getAllBranches();
        return ResponseEntity.ok(result);
    }
}
