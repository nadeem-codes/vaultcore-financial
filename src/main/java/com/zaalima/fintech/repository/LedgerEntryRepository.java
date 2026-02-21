package com.zaalima.fintech.repository;

import com.zaalima.fintech.entity.LedgerEntry;
import com.zaalima.fintech.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, Long> {

    /**
     * Ledger is IMMUTABLE.
     * Balance is derived from SUM(CR) - SUM(DR)
     */
    @Query("""
           SELECT 
               COALESCE(SUM(
                   CASE 
                       WHEN l.entryType = 'CR' THEN l.amount
                       WHEN l.entryType = 'DR' THEN -l.amount
                       ELSE 0
                   END
               ), 0)
           FROM LedgerEntry l
           WHERE l.account = :account
           """)
    BigDecimal calculateBalance(Account account);

    List<LedgerEntry> findByAccount_AccountIdOrderByTimestampAsc(Long accountId);
}
