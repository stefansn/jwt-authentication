package com.expensemanager.expensemanager.dto;

public class CurrencyDto {
    private Long id;
    private String currencyType;

    public CurrencyDto() {
    }

    public CurrencyDto(String currencyType) {
        this.currencyType = currencyType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
}
