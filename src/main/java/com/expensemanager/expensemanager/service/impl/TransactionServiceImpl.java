package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Transaction;
import com.expensemanager.expensemanager.repository.TransactionRepository;
import com.expensemanager.expensemanager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) throws ResourceNotFoundException {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for " + id));
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
