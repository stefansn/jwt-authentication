package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.TransactionDto;
import com.expensemanager.expensemanager.mapper.TransactionMapper;
import com.expensemanager.expensemanager.model.Transaction;
import com.expensemanager.expensemanager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    @Autowired
    private final TransactionService transactionService;

    @Autowired
    private final TransactionMapper transactionMapper;

    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping("/transactions")
    public List<TransactionDto> getAll() {
        List<Transaction> categories = transactionService.findAll();
        return categories.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/transaction/create")
    public TransactionDto createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toEntity(transactionDto);
        Transaction transactionResult = transactionService.save(transaction);
        return transactionMapper.toDto(transactionResult);
    }

    @PutMapping("/transaction/update/{id}")
    public TransactionDto updateTransaction(@PathVariable(value="id") Long id,
                                      @Valid @RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toEntity(transactionDto);
        Transaction transactionResult =transactionService.save(transaction);
        return transactionMapper.toDto(transactionResult);
    }

    @GetMapping("/transaction/{id}")
    public TransactionDto getTransactionById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Transaction transaction = transactionService.findById(id);
        return transactionMapper.toDto(transaction);
    }

    @DeleteMapping("/transaction//{id}")
    public void deleteTransaction(@PathVariable(value="id") Long id){
        transactionService.delete(id);
    }
}
