package com.transaction.demo.event;

// TransactionEventListener.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.transaction.demo.service.TransactionService;

@Component
public class TransactionEventListener {

    private final TransactionService transactionService;

    @Autowired
    public TransactionEventListener(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @TransactionalEventListener
    public void handleTransactionEvent(TransactionEvent transactionEvent) {
        transactionService.processTransactionEvent(transactionEvent);
    }
}
