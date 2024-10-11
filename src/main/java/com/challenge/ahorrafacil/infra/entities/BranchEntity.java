package com.challenge.ahorrafacil.infra.entities;

import com.challenge.ahorrafacil.domain.models.Branch;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;
    private String name;
    private String city;

    public BranchEntity() {
    }

    public BranchEntity(Long branchId, String name, String city) {
        this.branchId = branchId;
        this.name = name;
        this.city = city;
    }

    public static BranchEntity fromDomainModel(Branch branch) {
        return new BranchEntity(branch.getId(), branch.getName(), branch.getCity());
    }

    public Branch toDomainModel() {
        return new Branch(branchId, name, city);
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
