package com.sid.bankAccount_service;

import com.sid.bankAccount_service.entities.BankAccount;
import com.sid.bankAccount_service.entities.Customer;
import com.sid.bankAccount_service.enums.AccountType;
import com.sid.bankAccount_service.repositories.BankAccountRepository;
import com.sid.bankAccount_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {

            Stream.of("ayoub","jawada","younes","zakaria").forEach(
                    c -> {
                        Customer customer = Customer.builder()
                                .name(c)
                                .build();

                        customerRepository.save(customer);
                    }
            );

            customerRepository.findAll().forEach(c-> {

                for (int i = 1; i <= 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .createdAt(new Date())
                            .balance(10000+Math.random()*90000)
                            .currency("MAD")
                            .type(Math.random() > 0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .customer(c)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }


            });



        };


    }
}
