package com.transaction.demo.event;

// TransactionEventPublisher.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TransactionEventSource.class)
public class TransactionEventPublisher {

    private final TransactionEventSource transactionEventSource;

    @Autowired
    public TransactionEventPublisher(TransactionEventSource transactionEventSource) {
        this.transactionEventSource = transactionEventSource;
    }

    public void publishTransactionEvent(TransactionEvent transactionEvent) {
        MessageChannel messageChannel = transactionEventSource.transactionEventOut();
        Message<TransactionEvent> message = MessageBuilder.withPayload(transactionEvent).build();
        messageChannel.send(message);
    }
}
