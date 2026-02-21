package com.zaalima.fintech.service;

import com.zaalima.fintech.entity.Account;
import com.zaalima.fintech.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface LedgerService {

    void recordDebit(Account account,
                     Transaction transaction,
                     BigDecimal amount);

    void recordCredit(Account account,
                      Transaction transaction,
                      BigDecimal amount);

    List<Transaction> getTransactionHistory(Long userId);

    // ⭐ ADD THIS METHOD
    BigDecimal calculateBalance(Account account);
}