package com.zaalima.fintech.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class TransferRequest {

    @NotNull(message = "Source account is required")
    private Long fromAccountId;

    @NotNull(message = "Destination account is required")
    private Long toAccountId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Minimum transfer amount is 0.01")
    private BigDecimal amount;

    // ===== Getters & Setters =====

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUserId'");
    }

    public Long getInitiatedByUserId() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getInitiatedByUserId'");
    }
}
