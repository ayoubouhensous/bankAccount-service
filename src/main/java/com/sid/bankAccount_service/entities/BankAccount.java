package com.sid.bankAccount_service.entities;

import com.sid.bankAccount_service.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id

    private String id ;

    private Date createdAt;

    private double balance;

    private String currency;

    private AccountType type ;


    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;






}
