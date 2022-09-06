package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.model.main.Customer;

public interface CustomerDAO {
    Customer findByUsername(String username);
    Customer saveCustomer(Customer customer);
    Boolean doesUsernameAlreadyExists(String username);
    Boolean doesPhoneNumberAlreadyExists(String phoneNumber);
}