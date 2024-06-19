package com.example.SpringBoot_HIbernate_jpa.repository;

import com.example.SpringBoot_HIbernate_jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
