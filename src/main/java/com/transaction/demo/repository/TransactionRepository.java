package com.transaction.demo.repository;

import java.util.Date;
import java.util.List;

// TransactionRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByDateBetweenAndStatusIn(Date startDate, Date endDate, List<String> statuses);
}

