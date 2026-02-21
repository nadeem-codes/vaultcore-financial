package com.zaalima.fintech.service;

import java.math.BigDecimal;

import com.zaalima.fintech.dto.TransferRequest;



public interface TransferService {

    void transferMoney(
            Long fromAccountId,
            Long toAccountId,
            BigDecimal amount,
            Long initiatedByUserId
    );

    Object transferMoney(TransferRequest request);
}
