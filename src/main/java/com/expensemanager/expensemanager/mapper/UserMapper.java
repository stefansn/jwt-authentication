package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.UserDto;
import com.expensemanager.expensemanager.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
