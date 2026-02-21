package com.zaalima.fintech.service;

import com.zaalima.fintech.dto.AccountBalanceResponse;
import com.zaalima.fintech.dto.AccountCreateRequest;

public interface AccountService {

    AccountBalanceResponse createAccount(AccountCreateRequest request);

    AccountBalanceResponse getBalance(Long accountId);
    void freezeAccount(Long accountId);
}
