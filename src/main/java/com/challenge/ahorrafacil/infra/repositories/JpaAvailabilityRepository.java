package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.infra.entities.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaAvailabilityRepository extends JpaRepository<AvailabilityEntity, Long> {
    List<AvailabilityEntity> findByBranch_BranchId(Long branchId);

}
