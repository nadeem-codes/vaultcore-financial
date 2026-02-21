package com.zaalima.fintech.repository;

import com.zaalima.fintech.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByStatus(String status);


}