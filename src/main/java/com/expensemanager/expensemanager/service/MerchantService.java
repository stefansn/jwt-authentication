package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Merchant;

import java.util.List;

public interface MerchantService {
    List<Merchant> findAll();

    Merchant findById(Long id) throws ResourceNotFoundException;

    Merchant save(Merchant merchant);

    void delete(Long id);
}
