package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.CategoryDto;
import com.expensemanager.expensemanager.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
   CategoryDto toDto(Category category);
   Category toEntity(CategoryDto categoryDto);
}
