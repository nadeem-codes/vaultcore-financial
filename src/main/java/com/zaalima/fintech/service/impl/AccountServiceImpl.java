package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.dto.AccountBalanceResponse;
import com.zaalima.fintech.dto.AccountCreateRequest;
import com.zaalima.fintech.entity.Account;
import com.zaalima.fintech.entity.User;
import com.zaalima.fintech.repository.AccountRepository;
import com.zaalima.fintech.repository.UserRepository;
import com.zaalima.fintech.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository,
                              UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    // ✅ CREATE ACCOUNT
    @Override
    public AccountBalanceResponse createAccount(AccountCreateRequest request) {

        // Get user directly from repository
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Create account
        Account account = new Account(user);

        accountRepository.save(account);

        return new AccountBalanceResponse(
                account.getAccountId(),
                account.getBalance(),
                "INR"
        );
    }

    @Override
    public AccountBalanceResponse getBalance(Long accountId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
    }

    @Override
    public void freezeAccount(Long accountId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'freezeAccount'");
    }
}