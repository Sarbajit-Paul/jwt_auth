package com.aingenious.repository.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.aingenious.model.PayPortal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class PayPortalRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public PayPortal findByOrgNameAndPoNumber(String orgName, Integer poNumber) {
        String jpql = "SELECT p FROM PayPortal p WHERE p.orgName = :orgName AND p.poNumber = :poNumber";
        TypedQuery<PayPortal> query = entityManager.createQuery(jpql, PayPortal.class);
        query.setParameter("orgName", orgName);
        query.setParameter("poNumber", poNumber);
        List<PayPortal> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }
}
