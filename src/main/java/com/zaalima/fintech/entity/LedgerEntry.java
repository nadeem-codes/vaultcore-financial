package com.zaalima.fintech.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ledger_entries")
public class LedgerEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false, updatable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id", nullable = false, updatable = false)
    private Transaction transaction;

    @Column(nullable = false, precision = 19, scale = 4, updatable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 5, updatable = false)
    private String entryType; // DR / CR

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    protected LedgerEntry() {
        // JPA
    }

    public LedgerEntry(Account account, Transaction transaction,
                       BigDecimal amount, String entryType) {
        this.account = account;
        this.transaction = transaction;
        this.amount = amount;
        this.entryType = entryType;
        this.timestamp = LocalDateTime.now();
    }

    public Long getEntryId() {
        return entryId;
    }

    public Account getAccount() {
        return account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getEntryType() {
        return entryType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
