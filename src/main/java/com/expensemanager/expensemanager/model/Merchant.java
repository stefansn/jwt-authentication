package com.expensemanager.expensemanager.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="merchant")
public class Merchant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Merchant(){

    }

    public Merchant(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}