package com.transaction.demo.event;

// TransactionEvent.java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {
    private Long transactionId;
    private String eventType;  // "COMPLETED", "IN PROGRESS", "REJECTED", etc.
}

