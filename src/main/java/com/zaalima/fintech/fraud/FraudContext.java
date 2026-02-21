package com.zaalima.fintech.fraud;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FraudContext {

    private final Set<String> verifiedTransactions =
            ConcurrentHashMap.newKeySet();

    public void markVerified(String transactionId) {
        verifiedTransactions.add(transactionId);
    }

    public boolean isVerified(String transactionId) {
        return verifiedTransactions.contains(transactionId);
    }

    public void remove(String transactionId) {
        verifiedTransactions.remove(transactionId);
    }
}
