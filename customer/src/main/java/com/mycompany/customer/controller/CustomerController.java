package com.mycompany.customer.controller;

import com.mycompany.customer.services.CustomerService;
import com.mycompany.customer.model.Customer;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PostMapping("/get")
    public List<Customer> getCustomer(@RequestBody Set<Long> idList){
       return customerService.getCustomerList(idList);
    }
}
