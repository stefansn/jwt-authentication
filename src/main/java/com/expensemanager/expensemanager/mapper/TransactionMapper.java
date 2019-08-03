package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.TransactionDto;
import com.expensemanager.expensemanager.model.Category;
import com.expensemanager.expensemanager.model.Merchant;
import com.expensemanager.expensemanager.model.Transaction;
import com.expensemanager.expensemanager.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {
    @Autowired
    EntityManager entityManager;

    public abstract TransactionDto toDto(Transaction transaction);

    @Mapping(target="category", ignore=true)
    @Mapping(target="merchant", ignore=true)
    @Mapping(target="user", ignore=true)
    public abstract Transaction toEntity(TransactionDto transactionDto);

    @AfterMapping
    void afterToEntity(@MappingTarget Transaction transaction, TransactionDto transactionDto){
        Long id = transactionDto.getCategoryDto().getId();
        Category category = entityManager.find(Category.class, id);
        transaction.setCategory(category);

        id = transactionDto.getMerchantDto().getId();
        Merchant merchant = entityManager.find(Merchant.class, id);
        transaction.setMerchant(merchant);

        id = transactionDto.getUserDto().getId();
        User user = entityManager.find(User.class, id);
        transaction.setUser(user);
    }
}
