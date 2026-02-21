package com.zaalima.fintech.fraud;

import com.zaalima.fintech.dto.TransferRequest;
import com.zaalima.fintech.service.NotificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Aspect
@Component
public class FraudAspect {

    private final FraudProperties fraudProperties;
    private final FraudContext fraudContext;
    private final NotificationService notificationService;

    public FraudAspect(FraudProperties fraudProperties,
                       FraudContext fraudContext,
                       NotificationService notificationService) {
        this.fraudProperties = fraudProperties;
        this.fraudContext = fraudContext;
        this.notificationService = notificationService;
    }

    /**
     * Intercepts all transferMoney() calls
     */
    @Before("execution(* com.zaalima.fintech.service.impl.TransferServiceImpl.transferMoney(..))")
    public void detectFraud(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof TransferRequest request) {

                BigDecimal amount = request.getAmount();

                if (amount.compareTo(fraudProperties.getThreshold()) > 0) {

                    String transactionId = UUID.randomUUID().toString();

                    // Simulate sending OTP
                    notificationService.send2FA(
                            request.getFromAccountId(),
                            transactionId
                    );

                    if (!fraudContext.isVerified(transactionId)) {
                        throw new FraudException(
                                "Transaction blocked: 2FA verification required"
                        );
                    }

                    fraudContext.remove(transactionId);
                }
            }
        }
    }
}
