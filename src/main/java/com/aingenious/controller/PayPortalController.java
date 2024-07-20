package com.aingenious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aingenious.model.PayPortal;
import com.aingenious.model.RequestData;
import com.aingenious.service.PayPortalService;

@RestController
@RequestMapping("/api")
public class PayPortalController {

    @Autowired
    private PayPortalService payPortalService;

    @PostMapping("/payportal")
    public ResponseEntity<?> getPayPortal(@RequestBody RequestData request) {
        PayPortal payPortal = payPortalService.getPayPortal(request.getOrgName(), request.getPoNumber());
        if (payPortal != null) {
            return ResponseEntity.ok(payPortal);
        } else {
            return ResponseEntity.status(404).body("No record found");
        }
    }
    @PostMapping("/payportal/dataEntry")
    public ResponseEntity<?> createPayPortal(@RequestBody PayPortal payPortal) {
        PayPortal createdPayPortal = payPortalService.savePayPortal(payPortal);
        return ResponseEntity.ok(createdPayPortal);
    }
    @DeleteMapping("/payportal/dataDelete")
    public ResponseEntity<?> deletePayPortal(@RequestBody RequestData request) {
        payPortalService.deletePayPortal(request.getOrgName(), request.getPoNumber());
        return ResponseEntity.ok("Record deleted successfully");
    }
}
