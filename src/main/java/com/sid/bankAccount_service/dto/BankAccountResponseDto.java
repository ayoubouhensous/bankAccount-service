package com.sid.bankAccount_service.dto;

import com.sid.bankAccount_service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDto {

    private String id ;

    private Date createdAt;

    private double balance;

    private String currency;

    private AccountType type ;
}
