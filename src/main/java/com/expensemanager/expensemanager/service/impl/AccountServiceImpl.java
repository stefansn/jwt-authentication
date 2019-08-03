package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.AccountDto;
import com.expensemanager.expensemanager.mapper.AccountMapper;
import com.expensemanager.expensemanager.model.Account;
import com.expensemanager.expensemanager.repository.AccountRepository;
import com.expensemanager.expensemanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) throws ResourceNotFoundException {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for " + id));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    public AccountDto convertToDto(Account account) {
        AccountDto accountDto = accountMapper.toDto(account);

        return accountDto;
    }

    public Account convertToEntity(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);

        return account;
    }
}
