package com.expensemanager.expensemanager.model;

import javax.persistence.*;

@Entity(name="budget")
public class Budget {
    @Id
    @GeneratedValue
    private Long id;
    private Double amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Budget(){

    }

    public Budget(Double amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="amount", nullable = false)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
