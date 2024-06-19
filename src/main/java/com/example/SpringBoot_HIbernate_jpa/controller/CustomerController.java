package com.example.SpringBoot_HIbernate_jpa.controller;


import com.example.SpringBoot_HIbernate_jpa.entity.Customer;
import com.example.SpringBoot_HIbernate_jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    //create customer POST
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCostumer(customer);
    }

    //update Customer  PUT
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    // delete customer  DELETE
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-connection")
    public String testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Connected to: " + connection.getMetaData().getURL();
        } catch (SQLException e) {
            return "Failed to connect: " + e.getMessage();
        }
    }

}
