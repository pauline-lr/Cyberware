package com.spring.henallux.cyberware.controller;

import com.spring.henallux.cyberware.dataAccess.dataAccessObject.CustomerDAO;
import com.spring.henallux.cyberware.model.main.Customer;
import com.spring.henallux.cyberware.model.other.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/signin")
public class SigninController {
    private CustomerDAO customerDAO;

    @Autowired
    public SigninController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // create customer objet for post via submit
    @RequestMapping(method = RequestMethod.GET)
    public String getSigninPage(Model model) {
        model.addAttribute(Constant.CUSTOMER, new Customer());
        return "integrated:signin";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String postSigninForm(@Valid @ModelAttribute(value = Constant.CUSTOMER) Customer customer,
                                 final BindingResult errors,
                                 HttpServletRequest request) {
        if (!errors.hasErrors()) {
            if (isCustomerUnique(customer)) {
                String clearPassword = customer.getPassword();
                customer.encodePassword();
                customer.addAccountStatus();
                customerDAO.saveCustomer(customer);
                try {
                    request.login(customer.getUsername(), clearPassword);
                } catch (ServletException servletException) {
                    servletException.printStackTrace();
                }
                return "redirect:/";
            }else{
                errors.rejectValue("username","usernameAlreadyAssigned");
            }
        }
        return "integrated:signin";
    }

    private boolean isCustomerUnique(Customer customer) {
        if (!customerDAO.doesUsernameAlreadyExists(customer.getUsername())) {
            if (!customer.isPhoneNumberNull()) {
                return !(customerDAO.doesPhoneNumberAlreadyExists(customer.getPhoneNumber()));
            }
            return true;
        }
        return false;
    }
}
