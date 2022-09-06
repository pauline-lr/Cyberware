package com.spring.henallux.cyberware.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier", updatable = false, nullable = false)
    private Integer identifier;
    @Column(name = "is_paid")
    private Boolean isPaid;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "identifier")
    private CustomerEntity customer;

    public PurchaseEntity() {}

    public PurchaseEntity(Integer identifier, Boolean isPaid, Date date, CustomerEntity customer) {
        setIdentifier(identifier);
        setPaid(isPaid);
        setDate(date);
        setCustomer(customer);
    }

    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Boolean getPaid() {
        return isPaid;
    }
    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}