package com.sid.bankAccount_service.repositories;

import com.sid.bankAccount_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
