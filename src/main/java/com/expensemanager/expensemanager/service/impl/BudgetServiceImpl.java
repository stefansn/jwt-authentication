package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Budget;
import com.expensemanager.expensemanager.repository.BudgetRepository;
import com.expensemanager.expensemanager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }


    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Budget findById(Long id) throws ResourceNotFoundException {
        return budgetRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Budget not found for " + id));
    }

    @Override
    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }
}
