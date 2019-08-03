package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.MerchantDto;
import com.expensemanager.expensemanager.model.Merchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper {
    MerchantDto toDto(Merchant merchant);
    Merchant toEntity(MerchantDto merchantDto);
}
