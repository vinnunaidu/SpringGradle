package com.example.demo;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
     
    @Autowired
    private CustomerRepository customerRepository;
     
    @Test
    public void whenFindingCustomerById_thenCorrect() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        assertThat(customerRepository.findById(1L)).isInstanceOf(Optional.class);
    }
     
    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        customerRepository.save(new Customer("Julie", "julie@domain.com"));
        assertThat(customerRepository.findAll()).isInstanceOf(List.class);
    }
}