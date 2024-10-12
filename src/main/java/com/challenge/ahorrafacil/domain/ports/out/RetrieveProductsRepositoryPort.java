package com.challenge.ahorrafacil.domain.ports.out;

import com.challenge.ahorrafacil.domain.models.Product;

import java.util.List;

public interface RetrieveProductsRepositoryPort {

    List<Product> findByBranchId(Long branchId);
    Product findById(Long id);
}
