package com.example.demo.controller;


import com.example.demo.entities.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customer")
    public void sayHello(@RequestBody Customer customer){

        customerService.createCustomer(customer);
    }
}
