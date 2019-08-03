package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.BudgetDto;
import com.expensemanager.expensemanager.model.Budget;
import com.expensemanager.expensemanager.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring")
public abstract class BudgetMapper {
    @Autowired
    EntityManager entityManager;

    public abstract BudgetDto toDto(Budget budget);

    @Mapping(target = "user", ignore = true)
    public abstract Budget toEntity(BudgetDto budgetDto);

    @AfterMapping
    void afterToEntity(@MappingTarget Budget budget, BudgetDto budgetDto){
        Long id = budgetDto.getId();
        budget.setUser(entityManager.find(User.class, id));
    }
}
