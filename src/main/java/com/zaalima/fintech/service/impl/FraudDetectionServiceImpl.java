package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.exception.FraudDetectedException;
import com.zaalima.fintech.service.FraudDetectionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private static final BigDecimal FRAUD_THRESHOLD = new BigDecimal("100000");

    @Override
    public void evaluateTransaction(Long userId, BigDecimal amount) {
        if (amount.compareTo(FRAUD_THRESHOLD) > 0) {
            throw new FraudDetectedException("High-value transaction detected");
        }
    }
}
