package com.transaction.service;

import com.Transaction.entity.Transaction;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactionsByAmountRange(double initialRange, double finalRange);
    List<Transaction> getTransactionsSortedByAmount();
}
