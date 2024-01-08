package com.transaction.demo.controller;
import java.util.Date;
import java.util.List;

// TransactionController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.demo.entity.Transaction;
import com.transaction.demo.service.TransactionService;
import com.transaction.demo.util.ESAPISanitizerUtil;




@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactionsByDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
    	 String sanitizedStartDate = ESAPISanitizerUtil.sanitizeInput(startDate);
         String sanitizedEndDate = ESAPISanitizerUtil.sanitizeInput(endDate);
        return transactionService.getTransactionsByDateRange(sanitizedStartDate, sanitizedEndDate);
    }
}
