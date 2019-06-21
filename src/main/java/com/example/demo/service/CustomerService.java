package com.example.demo.service;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        return customer.orElseGet(Customer::new);
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
