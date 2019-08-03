package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.BudgetDto;
import com.expensemanager.expensemanager.mapper.BudgetMapper;
import com.expensemanager.expensemanager.model.Budget;
import com.expensemanager.expensemanager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @Autowired
    private BudgetMapper budgetMapper;

    @GetMapping("/budgets")
    public List<BudgetDto> getAll(){
        List<Budget> budgetList = budgetService.findAll();
        return budgetList.stream().map(budgetMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/budget/create")
    public BudgetDto create(@Valid @RequestBody BudgetDto budgetDto){
        Budget budget = budgetMapper.toEntity(budgetDto);
        Budget budgetResult = budgetService.save(budget);
        return budgetMapper.toDto(budgetResult);
    }

    @PutMapping("/budget/update/{id}")
    public BudgetDto update(@PathVariable(value="id") Long id, @Valid @RequestBody BudgetDto budgetDto){
        Budget budget = budgetMapper.toEntity(budgetDto);
        Budget budgetResult = budgetService.save(budget);
        return budgetMapper.toDto(budgetResult);
    }

    @GetMapping("/budget/{id}")
    public BudgetDto getById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Budget budget = budgetService.findById(id);
        return budgetMapper.toDto(budget);
    }

    @DeleteMapping("/budget/delete/{id}")
    public void deleteById(@PathVariable(value="id") Long id){
        budgetService.delete(id);
    }






}
