package com.challenge.ahorrafacil.application.services;

import com.challenge.ahorrafacil.domain.models.Product;
import com.challenge.ahorrafacil.domain.ports.in.ProductsByBranchUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductsByBranchUseCase {
    private final ProductsByBranchUseCase productsByBranchUseCase;

    public ProductService(ProductsByBranchUseCase productsByBranchUseCase) {
        this.productsByBranchUseCase = productsByBranchUseCase;
    }

    @Override
    public List<Product> findByBranchId(Long branchId) {
        return productsByBranchUseCase.findByBranchId(branchId);
    }
}
