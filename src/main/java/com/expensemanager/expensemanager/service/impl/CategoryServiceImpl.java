package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.Category;
import com.expensemanager.expensemanager.repository.CategoryRepository;
import com.expensemanager.expensemanager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) throws ResourceNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for " + id));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
