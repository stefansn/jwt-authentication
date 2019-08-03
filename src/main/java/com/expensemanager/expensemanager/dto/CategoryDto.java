package com.expensemanager.expensemanager.dto;

public class CategoryDto {
    private Long id;
    private String categoryType;

    public CategoryDto() {
    }

    public CategoryDto(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
