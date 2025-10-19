package com.sid.bankAccount_service.web;


import com.sid.bankAccount_service.dto.BankAccountRequestDto;
import com.sid.bankAccount_service.dto.BankAccountResponseDto;
import com.sid.bankAccount_service.entities.BankAccount;
import com.sid.bankAccount_service.repositories.BankAccountRepository;
import com.sid.bankAccount_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;


    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount getAccountById(@Argument  String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Bank account with id: %s not found",id)));
    }

    @MutationMapping
    public BankAccountResponseDto saveAccount(@Argument BankAccountRequestDto bankAccountdto){
        return accountService.addBankAccount(bankAccountdto);
    }

    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id , @Argument BankAccountRequestDto bankAccountdto){
            return accountService.updateBankAccount(id,bankAccountdto);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }



}
