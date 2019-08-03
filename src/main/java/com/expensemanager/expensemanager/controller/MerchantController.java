package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.MerchantDto;
import com.expensemanager.expensemanager.mapper.MerchantMapper;
import com.expensemanager.expensemanager.model.Merchant;
import com.expensemanager.expensemanager.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MerchantController {
    @Autowired
    private final MerchantService merchantService;

    @Autowired
    private final MerchantMapper merchantMapper;

    public MerchantController(MerchantService merchantService, MerchantMapper merchantMapper) {
        this.merchantService = merchantService;
        this.merchantMapper = merchantMapper;
    }

    @GetMapping("/merchants")
    public List<MerchantDto> getAll() {
        List<Merchant> categories = merchantService.findAll();
        return categories.stream()
                .map(merchantMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/merchant/create")
    public MerchantDto createMerchant(@Valid @RequestBody MerchantDto merchantDto) {
        Merchant merchant = merchantMapper.toEntity(merchantDto);
        Merchant merchantResult = merchantService.save(merchant);
        return merchantMapper.toDto(merchantResult);
    }

    @PutMapping("/merchant/update/{id}")
    public MerchantDto updateMerchant(@PathVariable(value="id") Long id,
                                      @Valid @RequestBody MerchantDto merchantDto) {
        Merchant merchant = merchantMapper.toEntity(merchantDto);
        Merchant merchantResult =merchantService.save(merchant);
        return merchantMapper.toDto(merchantResult);
    }

    @GetMapping("/merchant/{id}")
    public MerchantDto getMerchantById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Merchant merchant = merchantService.findById(id);
        return merchantMapper.toDto(merchant);
    }

    @DeleteMapping("/merchant/{id}")
    public void deleteMerchant(@PathVariable(value="id") Long id){
        merchantService.delete(id);
    }
}
