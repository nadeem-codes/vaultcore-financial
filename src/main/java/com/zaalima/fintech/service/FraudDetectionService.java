package com.zaalima.fintech.service;

import java.math.BigDecimal;

public interface FraudDetectionService {

    void evaluateTransaction(
            Long userId,
            BigDecimal amount
    );
}
