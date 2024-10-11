package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.domain.models.Product;
import com.challenge.ahorrafacil.domain.ports.out.RetrieveProductsRepositoryPort;
import com.challenge.ahorrafacil.infra.entities.AvailabilityEntity;
import com.challenge.ahorrafacil.infra.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaProductRepositoryAdapter implements RetrieveProductsRepositoryPort {
    private final JpaProductRepository jpaProductRepository;
    private final JpaAvailabilityRepository jpaAvailabilityRepository;

    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository, JpaAvailabilityRepository jpaAvailabilityRepository) {
        this.jpaProductRepository = jpaProductRepository;
        this.jpaAvailabilityRepository = jpaAvailabilityRepository;
    }

    @Override
    public List<Product> findByBranchId(Long branchId) {
        List<AvailabilityEntity> availabilities = jpaAvailabilityRepository.findByBranch_BranchId(branchId);
        return availabilities.stream().map(AvailabilityEntity::getProduct).map(ProductEntity::toDomainModel).collect(Collectors.toList());
    }


}
