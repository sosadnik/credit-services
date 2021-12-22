package com.mycompany.customer.services;

import com.mycompany.customer.repository.CreditRepository;
import com.mycompany.customer.model.Customer;
import com.mycompany.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CreditRepository creditRepository;

    public void createCustomer(Customer customer) {
        creditRepository.save(customer.getCredit());
        customerRepository.save(customer);
    }

    public List<Customer> getCustomerList(Set<Long> idList) {
        return  customerRepository.findAllByCredit_IdIn(idList);
    }
}
