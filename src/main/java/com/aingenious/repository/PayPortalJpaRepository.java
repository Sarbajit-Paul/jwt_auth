package com.aingenious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aingenious.model.PayPortal;

@Repository
public interface PayPortalJpaRepository extends JpaRepository<PayPortal, Integer> {
    PayPortal findByOrgNameAndPoNumber(String orgName, Integer poNumber);
    void deleteByOrgNameAndPoNumber(String orgName, Integer poNumber);
}
