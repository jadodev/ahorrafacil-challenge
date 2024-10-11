package com.challenge.ahorrafacil.infra.repositories;

import com.challenge.ahorrafacil.infra.entities.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBranchRepository extends JpaRepository<BranchEntity, Long> {
}
