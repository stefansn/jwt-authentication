package com.expensemanager.expensemanager.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="currency")
public class Currency {
    @Id
    @GeneratedValue
    private Long id;
    private String currencyType;

    public Currency(){

    }

    public Currency(String currencyType) {
        this.currencyType = currencyType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "currency_type", nullable = false)
    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
}
