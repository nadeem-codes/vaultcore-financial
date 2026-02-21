package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendTransactionAlert(Long userId, String message) {
    }

    @Override
    public void sendFraudVerification(Long userId, String channel) {
    }

    @Override
    public void send2FA(Long fromAccountId, String transactionId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'send2FA'");
    }
}
