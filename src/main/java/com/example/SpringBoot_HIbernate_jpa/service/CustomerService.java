package com.example.SpringBoot_HIbernate_jpa.service;

import com.example.SpringBoot_HIbernate_jpa.entity.Customer;
import com.example.SpringBoot_HIbernate_jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Transactional
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    @Transactional
    public Customer createCostumer(Customer customer){
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer customer){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if(existingCustomer != null){
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    @Transactional
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
