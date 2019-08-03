package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Merchant;
import com.expensemanager.expensemanager.repository.MerchantRepository;
import com.expensemanager.expensemanager.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }


    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant findById(Long id) throws ResourceNotFoundException {
        return merchantRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Merchant not found for " + id));
    }

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public void delete(Long id) {
        merchantRepository.deleteById(id);
    }
}
