package com.zaalima.fintech.controller;

import com.zaalima.fintech.fraud.FraudContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/fraud")
public class FraudController {

    private final FraudContext fraudContext;

    public FraudController(FraudContext fraudContext) {
        this.fraudContext = fraudContext;
    }

    @PostMapping("/verify/{transactionId}")
    public ResponseEntity<String> verify(@PathVariable String transactionId) {
        fraudContext.markVerified(transactionId);
        return ResponseEntity.ok("Transaction verified successfully");
    }
}
