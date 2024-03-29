package com.transaction.service;

import com.Transaction.entity.Transaction;
import com.Transaction.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements com.transaction.service.TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void addTransaction(Transaction transaction) {
        // Perform validation checks here if needed
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByAmountRange(double initialRange, double finalRange) {
        // Implement logic to retrieve transactions within the specified amount range
        return transactionRepository.findByAmountBetween(initialRange, finalRange);
    }

    @Override
    public List<Transaction> getTransactionsSortedByAmount() {
        // Implement logic to retrieve transactions sorted by amount
        return transactionRepository.findAllByOrderByAmountAsc();
    }
}
