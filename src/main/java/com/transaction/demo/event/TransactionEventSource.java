package com.transaction.demo.event;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionEventSource {
    String OUTPUT = "transaction-event-out";

    @Output(OUTPUT)
    MessageChannel transactionEventOut();
}
