package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> findAll();

    Transaction findById(Long id) throws ResourceNotFoundException;

    Transaction save(Transaction transaction);

    void delete(Long id);
}
