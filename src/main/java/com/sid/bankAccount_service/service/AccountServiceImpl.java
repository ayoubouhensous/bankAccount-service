package com.sid.bankAccount_service.service;

import com.sid.bankAccount_service.dto.BankAccountRequestDto;
import com.sid.bankAccount_service.dto.BankAccountResponseDto;
import com.sid.bankAccount_service.entities.BankAccount;
import com.sid.bankAccount_service.mapper.BankAccountMapper;
import com.sid.bankAccount_service.repositories.BankAccountRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public BankAccountResponseDto addBankAccount(BankAccountRequestDto bankAccountREquestDto) {

        BankAccount  bankAccount = bankAccountMapper.fromRequestDto(bankAccountREquestDto);

        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());

        bankAccountRepository.save(bankAccount);

        BankAccountResponseDto bankAccountResponseDto1 = bankAccountMapper.fromEntity(bankAccount);

        return bankAccountResponseDto1;
    }

    @Override
    public BankAccountResponseDto updateBankAccount(String id ,BankAccountRequestDto bankAccountDto) {

        BankAccount  bankAccount = bankAccountMapper.fromRequestDto(bankAccountDto);

        bankAccount.setId(id);
        bankAccount.setCreatedAt(new Date());

        bankAccountRepository.save(bankAccount);

        BankAccountResponseDto bankAccountResponseDto1 = bankAccountMapper.fromEntity(bankAccount);

        return bankAccountResponseDto1;

    }
}
