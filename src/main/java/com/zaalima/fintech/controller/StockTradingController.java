package com.zaalima.fintech.controller;

import com.zaalima.fintech.dto.StockTradeRequest;
import com.zaalima.fintech.dto.StockResponse;
import com.zaalima.fintech.service.impl.StockTradingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/stocks")
public class StockTradingController {

    private final StockTradingService stockTradingService;

    public StockTradingController(StockTradingService stockTradingService) {
        this.stockTradingService = stockTradingService;
    }

    @PostMapping("/buy")
    public ResponseEntity<StockResponse> buy(@Valid @RequestBody StockTradeRequest request) {
        return ResponseEntity.ok(stockTradingService.buyStock(request));
    }

    @PostMapping("/sell")
    public ResponseEntity<StockResponse> sell(@Valid @RequestBody StockTradeRequest request) {
        return ResponseEntity.ok(stockTradingService.sellStock(request));
    }
}
