package com.expensemanager.expensemanager.controller;
import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.AccountDto;
import com.expensemanager.expensemanager.mapper.AccountMapper;
import com.expensemanager.expensemanager.model.Account;
import com.expensemanager.expensemanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    private final AccountService accountService;

    @Autowired
    private final AccountMapper accountMapper;

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/accounts")
    public List<AccountDto> getAll(){
        List<Account> accounts = accountService.findAll();

        return accounts
                .stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/account/create")
    public AccountDto create(@Valid @RequestBody AccountDto accountDto){
        Account account = accountMapper.toEntity(accountDto);
        Account accountResult = accountService.save(account);
        return accountMapper.toDto(accountResult);
    }

    @PutMapping("/account/update/{id}")
    public AccountDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody AccountDto accountDto){
        Account account = accountMapper.toEntity(accountDto);
        Account accountResult = accountService.save(account);
        return accountMapper.toDto(accountResult);
    }

    @GetMapping("/account/{id}")
    public AccountDto getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Account account = accountService.findById(id);
        return accountMapper.toDto(account);
    }

    @DeleteMapping("/account/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        accountService.delete(id);
    }

}
