package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
