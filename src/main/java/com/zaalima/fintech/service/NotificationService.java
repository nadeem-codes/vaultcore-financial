package com.zaalima.fintech.service;

public interface NotificationService {

    void sendTransactionAlert(
            Long userId,
            String message
    );

    void sendFraudVerification(
            Long userId,
            String channel // SMS / EMAIL
    );

    void send2FA(Long fromAccountId, String transactionId);
}
