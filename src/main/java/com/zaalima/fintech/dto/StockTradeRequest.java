package com.zaalima.fintech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StockTradeRequest {

    @NotNull(message = "Account ID is required")
    private Long accountId;

    @NotBlank(message = "Stock symbol is required")
    private String stockSymbol;

    @Positive(message = "Quantity must be greater than zero")
    private int quantity;

    @NotBlank(message = "Trade type is required")
    private String tradeType; // BUY or SELL

    // ===== Getters & Setters =====

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTradeType() {
        return tradeType;
    }
    
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
}
