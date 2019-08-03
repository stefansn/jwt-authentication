package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.CurrencyDto;
import com.expensemanager.expensemanager.model.Currency;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CurrencyMapper {
    CurrencyDto toDto(Currency currency);
    Currency toEntity(CurrencyDto currencyDto);
}
