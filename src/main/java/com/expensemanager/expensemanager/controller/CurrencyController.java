package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.CurrencyDto;
import com.expensemanager.expensemanager.mapper.CurrencyMapper;
import com.expensemanager.expensemanager.model.Currency;
import com.expensemanager.expensemanager.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {
    @Autowired
    private final CurrencyService currencyService;
    
    @Autowired
    private final CurrencyMapper currencyMapper;

    public CurrencyController(CurrencyService currencyService, CurrencyMapper currencyMapper) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
    }

    @GetMapping("/currencies")
    public List<CurrencyDto> getAll() {
        List<Currency> categories = currencyService.findAll();
        return categories.stream()
                .map(currencyMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/currency/create")
    public CurrencyDto createCurrency(@Valid @RequestBody CurrencyDto currencyDto) {
        Currency currency = currencyMapper.toEntity(currencyDto);
        Currency currencyResult = currencyService.save(currency);
        return currencyMapper.toDto(currencyResult);
    }

    @PutMapping("/currency/update/{id}")
    public CurrencyDto updateCurrency(@PathVariable(value="id") Long id,
                                      @Valid @RequestBody CurrencyDto currencyDto) {
        Currency currency = currencyMapper.toEntity(currencyDto);
        Currency currencyResult =currencyService.save(currency);
        return currencyMapper.toDto(currencyResult);
    }

    @GetMapping("/currency/{id}")
    public CurrencyDto getCurrencyById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Currency currency = currencyService.findById(id);
        return currencyMapper.toDto(currency);
    }

    @DeleteMapping("/currency/{id}")
    public void deleteCurrency(@PathVariable(value="id") Long id){
        currencyService.delete(id);
    }
}
