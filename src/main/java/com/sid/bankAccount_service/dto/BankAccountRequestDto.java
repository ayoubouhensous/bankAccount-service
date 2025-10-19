package com.sid.bankAccount_service.dto;

import com.sid.bankAccount_service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
public class BankAccountRequestDto {

    private double balance;

    private String currency;

    private AccountType type ;
}
