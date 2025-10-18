package com.sid.bankAccount_service;

import com.sid.bankAccount_service.entities.BankAccount;
import com.sid.bankAccount_service.enums.AccountType;
import com.sid.bankAccount_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner start(BankAccountRepository  bankAccountRepository) {
        return args -> {

            for (int i = 1; i <= 10; i++) {
                BankAccount bankAccount = new BankAccount(
                        UUID.randomUUID().toString(),
                        new Date(),
                        10000+Math.random()*90000,
                        "MAD",
                        Math.random() > 0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT
                );
                bankAccountRepository.save(bankAccount);


            }

        };


    }
}
