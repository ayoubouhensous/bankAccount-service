package com.sid.bankAccount_service.service;

import com.sid.bankAccount_service.dto.BankAccountRequestDto;
import com.sid.bankAccount_service.dto.BankAccountResponseDto;

public interface AccountService {

     BankAccountResponseDto addBankAccount(BankAccountRequestDto bankAccountDto);
}
