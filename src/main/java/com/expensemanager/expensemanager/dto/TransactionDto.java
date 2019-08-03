package com.expensemanager.expensemanager.dto;

import java.util.Date;

public class TransactionDto {
    private Long id;
    private Date date;
    private CategoryDto categoryDto;
    private MerchantDto merchantDto;
    private UserDto userDto;

    public TransactionDto() {
    }

    public TransactionDto(Date date, CategoryDto categoryDto, MerchantDto merchantDto, UserDto userDto) {
        this.date = date;
        this.categoryDto = categoryDto;
        this.merchantDto = merchantDto;
        this.userDto = userDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public MerchantDto getMerchantDto() {
        return merchantDto;
    }

    public void setMerchantDto(MerchantDto merchantDto) {
        this.merchantDto = merchantDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
