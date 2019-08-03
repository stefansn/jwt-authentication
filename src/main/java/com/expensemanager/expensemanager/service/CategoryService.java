package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Long id) throws ResourceNotFoundException;

    void deleteById(Long id);
}
