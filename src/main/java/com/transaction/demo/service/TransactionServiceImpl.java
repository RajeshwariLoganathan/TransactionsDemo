package com.transaction.demo.service;

import java.util.Date;
import java.util.List;

// TransactionServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.demo.entity.Transaction;
import com.transaction.demo.event.TransactionEvent;
import com.transaction.demo.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate) {
        List<String> validStatuses = List.of("COMPLETED", "IN PROGRESS", "REJECTED");
        return transactionRepository.findByDateBetweenAndStatusIn(startDate, endDate, validStatuses);
    }

    @Transactional
    public void processTransactionEvent(TransactionEvent transactionEvent) {
        // Process the event (update transaction status, log, etc.)
        // ...

        // Save the updated transaction (if needed)
        Transaction updatedTransaction = transactionRepository.findById(transactionEvent.getTransactionId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        updatedTransaction.setStatus(transactionEvent.getEventType());
        transactionRepository.save(updatedTransaction);
    }
}

