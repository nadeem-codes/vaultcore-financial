package com.zaalima.fintech.dto;

public class StockResponse {

    private Long accountId;
    private String stockSymbol;
    private Integer quantity;
    private String status;

    // ✅ Constructor
    public StockResponse(Long accountId, String stockSymbol, Integer quantity, String status) {
        this.accountId = accountId;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters
    public Long getAccountId() {
        return accountId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }
}