package com.sid.bankAccount_service.repositories;

import com.sid.bankAccount_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
