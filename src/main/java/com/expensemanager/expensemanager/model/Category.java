package com.expensemanager.expensemanager.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="category")
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String categoryType;

    public Category(){

    }

    public Category(String categoryType) {
        this.categoryType = categoryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="category_type", nullable = false)
    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryType=" + categoryType +
                '}';
    }
}
