package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
