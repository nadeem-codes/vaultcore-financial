package com.zaalima.fintech.service.impl;

import java.math.BigDecimal;
import com.zaalima.fintech.dto.StockTradeRequest;
import com.zaalima.fintech.dto.StockResponse;
import com.zaalima.fintech.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class StockTradingServiceImpl implements StockTradingService {

    private final FraudDetectionService fraudDetectionService;

    public StockTradingServiceImpl(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    // BUY
    @Override
    public StockResponse buyStock(StockTradeRequest request) {

        fraudDetectionService.evaluateTransaction(
                request.getAccountId(),
                BigDecimal.valueOf(request.getQuantity())
        );

        return new StockResponse(
                request.getAccountId(),
                request.getStockSymbol(),
                request.getQuantity(),
                "BUY_SUCCESS"
        );
    }

    // SELL
    @Override
    public StockResponse sellStock(StockTradeRequest request) {

        fraudDetectionService.evaluateTransaction(
                request.getAccountId(),
                BigDecimal.valueOf(request.getQuantity())
        );

        return new StockResponse(
                request.getAccountId(),
                request.getStockSymbol(),
                request.getQuantity(),
                "SELL_SUCCESS"
        );
    }
}