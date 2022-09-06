package com.spring.henallux.cyberware.model.main;

import javax.validation.constraints.*;

import java.util.Date;

public class Purchase {
    private Integer identifier;
    @NotNull
    private Boolean isPaid;
    @NotNull
    private Date date;
    @NotNull
    private Customer customer;

    public Purchase() {}

    public Purchase(Integer identifier, Boolean isPaid, Date date, Customer customer) {
        setIdentifier(identifier);
        setPaid(isPaid);
        setDate(date);
        setCustomer(customer);
    }

    public Purchase(Customer customer) {
        setPaid(false);
        setDate(new Date());
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

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Purchase that = (Purchase) object;
        return (this.identifier.equals(that.identifier)) && (this.isPaid.equals(that.isPaid)) &&
                (this.date.equals(that.date)) && (this.customer.equals(that.customer));
    }
}