package com.zaalima.fintech.controller;

import com.zaalima.fintech.dto.TransferRequest;
import com.zaalima.fintech.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransferService transferService;

    public TransactionController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Object> transfer(@Valid @RequestBody TransferRequest request) {
        return ResponseEntity.ok(transferService.transferMoney(request));
    }

}