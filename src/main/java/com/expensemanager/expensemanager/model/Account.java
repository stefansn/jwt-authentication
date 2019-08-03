package com.expensemanager.expensemanager.model;

import javax.persistence.*;

@Entity(name="account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String accountType;

    @ManyToOne
    @JoinColumn(name="currency_id", nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Account(){

    }

    public Account(String accountType, Currency currency, User user) {
        this.accountType = accountType;
        this.currency = currency;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "account_type", nullable = false)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Column(name = "currency", nullable = false)
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountType=" + accountType +
                ", currency=" + currency +
                '}';
    }
}
