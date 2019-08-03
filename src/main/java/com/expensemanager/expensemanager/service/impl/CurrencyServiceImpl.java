package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Currency;
import com.expensemanager.expensemanager.repository.CurrencyRepository;
import com.expensemanager.expensemanager.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findById(Long id) throws ResourceNotFoundException {
        return currencyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Currenct not found for" + id));
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public void delete(Long id) {
        currencyRepository.deleteById(id);
    }
}
