package com.expensemanager.expensemanager.dto;

public class BudgetDto {
    private Long id;
    private Double amount;
    private UserDto userDto;

    public BudgetDto() {
    }

    public BudgetDto(Double amount, UserDto userDto) {
        this.amount = amount;
        this.userDto = userDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
