package com.expensemanager.expensemanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="merchant_id", nullable = false)
    private Merchant merchant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Transaction(){

    }

    public Transaction(Date date, Category category, Merchant merchant, User user) {
        this.date = date;
        this.category = category;
        this.merchant = merchant;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "category", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TransactionRepository{" +
                "id=" + id +
                ", date=" + date +
                ", category=" + category +
                '}';
    }
}
