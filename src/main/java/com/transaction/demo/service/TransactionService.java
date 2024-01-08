package com.transaction.demo.service;

//TransactionService.java
import java.util.Date;
import java.util.List;

import com.transaction.demo.entity.Transaction;

public interface TransactionService {
 List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate);
}

