package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.dto.TransferRequest;
import com.zaalima.fintech.entity.Account;
import com.zaalima.fintech.entity.Transaction;
import com.zaalima.fintech.exception.InsufficientBalanceException;
import com.zaalima.fintech.repository.AccountRepository;
import com.zaalima.fintech.repository.TransactionRepository;
import com.zaalima.fintech.service.FraudDetectionService;
import com.zaalima.fintech.service.TransferService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final FraudDetectionService fraudDetectionService;

    public TransferServiceImpl(AccountRepository accountRepository,
                               TransactionRepository transactionRepository,
                               FraudDetectionService fraudDetectionService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.fraudDetectionService = fraudDetectionService;
    }

    @Override
    @Transactional
    public void transferMoney(Long fromAccountId,
                              Long toAccountId,
                              BigDecimal amount,
                              Long initiatedByUserId) {

        fraudDetectionService.evaluateTransaction(initiatedByUserId, amount);

        Account from = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        Account to = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        //  Direct balance check (no LedgerService)
        if (from.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        // Update balances directly
        from.applyBalance(from.getBalance().subtract(amount));
        to.applyBalance(to.getBalance().add(amount));

        accountRepository.save(from);
        accountRepository.save(to);

        //  Save transaction
        Transaction tx = new Transaction(amount, "TRANSFER");
        tx.markCompleted();
        transactionRepository.save(tx);
    }

    @Override
    public Object transferMoney(TransferRequest request) {
        transferMoney(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount(),
                request.getInitiatedByUserId()
        );
        return "Transfer Successful";
    }
}