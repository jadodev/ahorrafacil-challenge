package com.challenge.ahorrafacil.application.usecases;

import com.challenge.ahorrafacil.application.services.ProductService;
import com.challenge.ahorrafacil.domain.models.Product;
import com.challenge.ahorrafacil.domain.ports.in.ProductsByBranchUseCase;
import com.challenge.ahorrafacil.domain.ports.out.RetrieveProductsRepositoryPort;

import java.util.List;

public class ProductsByBranchUseCaseImpl implements ProductsByBranchUseCase {

    private final RetrieveProductsRepositoryPort retrieveProductsRepositoryPort;

    public ProductsByBranchUseCaseImpl(RetrieveProductsRepositoryPort retrieveProductsRepositoryPort) {
        this.retrieveProductsRepositoryPort = retrieveProductsRepositoryPort;
    }

    @Override
    public List<Product> findByBranchId(Long branchId) {
        return retrieveProductsRepositoryPort.findByBranchId(branchId);
    }

    @Override
    public Product findById(Long id) {
        return retrieveProductsRepositoryPort.findById(id);
    }


}
