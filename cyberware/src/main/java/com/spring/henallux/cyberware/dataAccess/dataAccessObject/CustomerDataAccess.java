package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.dataAccess.entity.CustomerEntity;
import com.spring.henallux.cyberware.dataAccess.repository.CustomerRepository;
import com.spring.henallux.cyberware.dataAccess.utility.ModelEntityConverter;
import com.spring.henallux.cyberware.model.main.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerDataAccess implements CustomerDAO {
    private CustomerRepository customerRepository;
    private ModelEntityConverter converter;

    @Autowired
    public CustomerDataAccess(CustomerRepository customerRepository, ModelEntityConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    public Customer findByUsername(String username) {
        CustomerEntity customerEntity = customerRepository.findByUsername(username);
        return converter.customerEntityToCustomerModel(customerEntity);
    }

    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = converter.customerModelToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return converter.customerEntityToCustomerModel(customerEntity);
    }

    public Boolean doesUsernameAlreadyExists(String username) {
        return customerRepository.existsByUsername(username);
    }

    public Boolean doesPhoneNumberAlreadyExists(String phoneNumber) {
        return customerRepository.existsByPhoneNumber(phoneNumber);
    }
}