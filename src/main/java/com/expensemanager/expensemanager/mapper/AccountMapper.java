package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.AccountDto;
import com.expensemanager.expensemanager.model.Account;
import com.expensemanager.expensemanager.model.Currency;
import com.expensemanager.expensemanager.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {
    @Autowired
    EntityManager entityManager;

    public abstract AccountDto toDto(Account account);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "currency", ignore = true)
    public abstract Account toEntity(AccountDto accountDto);

    @AfterMapping
    void afterToEntity(@MappingTarget Account account, AccountDto accountDto) {
        Long id = accountDto.getUserDto().getId();
        User user = entityManager.find(User.class, id);
        account.setUser(user);

        id = accountDto.getCurrencyDto().getId();
        Currency currency = entityManager.find(Currency.class, id);
        account.setCurrency(currency);
    }
}
