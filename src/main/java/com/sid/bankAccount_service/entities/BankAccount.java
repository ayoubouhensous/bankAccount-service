package com.sid.bankAccount_service.entities;

import com.sid.bankAccount_service.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id

    private String id ;

    private Date createdAt;

    private double balance;

    private String currency;

    private AccountType type ;






}
