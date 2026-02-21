package com.zaalima.fintech.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    protected Account() {
        // JPA
    }

    public Account(User owner) {
        this.owner = owner;
        this.balance = BigDecimal.ZERO;
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
    }

    public Long getAccountId() {
        return accountId;
    }

    public User getOwner() {
        return owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void applyBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }

    public String getStatus() {
        return status;
    }

    public void freeze() {
        this.status = "FROZEN";
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
