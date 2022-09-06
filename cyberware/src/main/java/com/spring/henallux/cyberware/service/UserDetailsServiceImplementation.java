package com.spring.henallux.cyberware.service;

import com.spring.henallux.cyberware.dataAccess.dataAccessObject.CustomerDAO;
import com.spring.henallux.cyberware.model.main.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private CustomerDAO customerDAO;

    @Autowired
    public UserDetailsServiceImplementation(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDAO.findByUsername(username);
        if (customer != null) {
            return customer;
        }
        throw new UsernameNotFoundException("Customer not found");
    }
}