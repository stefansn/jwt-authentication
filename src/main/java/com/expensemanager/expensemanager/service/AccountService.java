package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(Long id) throws ResourceNotFoundException;

    Account save(Account account);

    void delete(Long id);
}
