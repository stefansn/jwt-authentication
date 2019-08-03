package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
