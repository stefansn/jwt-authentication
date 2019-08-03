package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.CategoryDto;
import com.expensemanager.expensemanager.mapper.CategoryMapper;
import com.expensemanager.expensemanager.model.Category;
import com.expensemanager.expensemanager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryService.findAll();
        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/category/create")
    public CategoryDto createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryResult = categoryService.save(category);
        return categoryMapper.toDto(categoryResult);
    }

    @PutMapping("/category/update/{id}")
    public CategoryDto updateCategory(@PathVariable(value="id") Long id,
                                      @Valid @RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryResult =categoryService.save(category);
        return categoryMapper.toDto(categoryResult);
    }

    @GetMapping("/category/{id}")
    public CategoryDto getCategoryById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Category category = categoryService.findById(id);
        return categoryMapper.toDto(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable(value="id") Long id){
        categoryService.deleteById(id);
    }
}
