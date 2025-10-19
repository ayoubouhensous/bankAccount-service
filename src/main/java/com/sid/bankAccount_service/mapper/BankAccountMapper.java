package com.sid.bankAccount_service.mapper;


import com.sid.bankAccount_service.dto.BankAccountRequestDto;
import com.sid.bankAccount_service.dto.BankAccountResponseDto;
import com.sid.bankAccount_service.entities.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    BankAccount fromRequestDto(BankAccountRequestDto dto);

    BankAccountResponseDto fromEntity(BankAccount bankAccount);
}