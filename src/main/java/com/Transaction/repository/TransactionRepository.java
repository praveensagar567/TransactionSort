package com.Transaction.repository;

import com.Transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAmountBetween(double initialRange, double finalRange);
    List<Transaction> findAllByOrderByAmountAsc();
}

