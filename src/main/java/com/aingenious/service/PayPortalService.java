package com.aingenious.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aingenious.model.PayPortal;
import com.aingenious.repository.PayPortalJpaRepository;

@Service
public class PayPortalService {

    @Autowired
    private PayPortalJpaRepository payPortalRepository;

    public PayPortal getPayPortal(String orgName, Integer poNumber) {
        return payPortalRepository.findByOrgNameAndPoNumber(orgName, poNumber);
    }

    public PayPortal savePayPortal(PayPortal payPortal) {
        return payPortalRepository.save(payPortal);
    }
    @Transactional
    public void deletePayPortal(String orgName, Integer poNumber) {
        payPortalRepository.deleteByOrgNameAndPoNumber(orgName, poNumber);
    }
}
