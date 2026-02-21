package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.dto.StockTradeRequest;
import com.zaalima.fintech.dto.StockResponse;

public interface StockTradingService {

    StockResponse buyStock(StockTradeRequest request);

    StockResponse sellStock(StockTradeRequest request);
}