package com.Transaction.controller;

import com.Transaction.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private com.transaction.service.TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
        // Perform validation checks here if needed
        if (transaction.getAmount() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction amount must be greater than or equal to 0");
        }
        transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction added successfully");
    }

    @GetMapping("/amount/{initialRange}/{finalRange}")
    public ResponseEntity<?> getTransactionsByAmountRange(
            @PathVariable("initialRange") double initialRange,
            @PathVariable("finalRange") double finalRange) {
        List<Transaction> transactions = transactionService.getTransactionsByAmountRange(initialRange, finalRange);
        if (transactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No transactions found in the specified range");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<?> getTransactionsSortedByAmount() {
        List<Transaction> transactions = transactionService.getTransactionsSortedByAmount();
        if (transactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No transactions found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }
}
