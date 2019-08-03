package com.expensemanager.expensemanager.dto;

public class AccountDto {
    private Long id;
    private String accountType;
    private CurrencyDto currencyDto;
    private UserDto userDto;

    public AccountDto() {
    }

    public AccountDto(String accountType, CurrencyDto currencyDto, UserDto userDto) {
        this.accountType = accountType;
        this.currencyDto = currencyDto;
        this.userDto = userDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public CurrencyDto getCurrencyDto() {
        return currencyDto;
    }

    public void setCurrencyDto(CurrencyDto currencyDto) {
        this.currencyDto = currencyDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
