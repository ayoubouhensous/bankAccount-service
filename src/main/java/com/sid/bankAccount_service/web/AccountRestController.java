package com.sid.bankAccount_service.web;


import com.sid.bankAccount_service.dto.BankAccountRequestDto;
import com.sid.bankAccount_service.dto.BankAccountResponseDto;
import com.sid.bankAccount_service.entities.BankAccount;
import com.sid.bankAccount_service.repositories.BankAccountRepository;
import com.sid.bankAccount_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("/bankAccounts")
    public List<BankAccount>  findAll() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount findById(@PathVariable String id) {
            return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account with id %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDto addBankAccount(@RequestBody BankAccountRequestDto bankAccountRequestDto) {
        return accountService.addBankAccount(bankAccountRequestDto);
    }

    @PostMapping("/bankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount existingAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account with id %s not found", id)));

        if (bankAccount.getBalance() != 0) {
            existingAccount.setBalance(bankAccount.getBalance());
        }

        if (bankAccount.getCurrency() != null && !bankAccount.getCurrency().isEmpty()) {
            existingAccount.setCurrency(bankAccount.getCurrency());
        }

        if (bankAccount.getType() != null) {
            existingAccount.setType(bankAccount.getType());
        }

        if (bankAccount.getCreatedAt() != null) {
            existingAccount.setCreatedAt(bankAccount.getCreatedAt());
        }

        return bankAccountRepository.save(existingAccount);
    }

    @GetMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }



}
