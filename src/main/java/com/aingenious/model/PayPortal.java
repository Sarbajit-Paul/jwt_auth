package com.aingenious.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pay_portal", uniqueConstraints = {
        @UniqueConstraint(columnNames = "org_name"),
        @UniqueConstraint(columnNames = "po_number")
})
public class PayPortal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_pay_portal_id")
    private Integer id;

    @Column(name = "org_name", nullable = false)
    private String orgName;

    @Column(name = "po_number", nullable = false)
    private Integer poNumber;

    @Column(name = "buyer", nullable = false)
    private String buyer;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    // Constructors, getters and setters

    public PayPortal() {
    }

    public PayPortal(String orgName, Integer poNumber, String buyer, Date dueDate) {
        this.orgName = orgName;
        this.poNumber = poNumber;
        this.buyer = buyer;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(Integer poNumber) {
        this.poNumber = poNumber;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

	



