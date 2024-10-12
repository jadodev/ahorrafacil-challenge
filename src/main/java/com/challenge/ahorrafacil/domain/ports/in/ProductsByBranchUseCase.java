package com.challenge.ahorrafacil.domain.ports.in;

import com.challenge.ahorrafacil.domain.models.Product;

import java.util.List;

public interface ProductsByBranchUseCase {
    List<Product> findByBranchId(Long branchId);

    Product findById(Long id);
}
