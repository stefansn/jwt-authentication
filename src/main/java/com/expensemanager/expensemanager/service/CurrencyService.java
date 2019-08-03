package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> findAll();

    Currency findById(Long id) throws ResourceNotFoundException;

    Currency save(Currency currency);

    void delete(Long id);
}
