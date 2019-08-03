package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Budget;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();

    Budget findById(Long id) throws ResourceNotFoundException;

    Budget save(Budget budget);

    void delete(Long id);
}
