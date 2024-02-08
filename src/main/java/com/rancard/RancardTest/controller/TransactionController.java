package com.rancard.RancardTest.controller;

import com.rancard.RancardTest.Exception.InvalidTransactionException;
import com.rancard.RancardTest.Exception.TransactionNotFoundException;
import com.rancard.RancardTest.entity.Transaction;
import com.rancard.RancardTest.entity.User;
import com.rancard.RancardTest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        try {
            Transaction createdTransaction = transactionService.createTransaction(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
        } catch (InvalidTransactionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public List<Transaction> getUsers(){
        return transactionService.getTransaction();
    }

    @GetMapping("/get")
    public ResponseEntity<Transaction> getTransaction(@RequestParam Integer id) {
        try {
            Transaction transaction = transactionService.getTransaction(id);
            return ResponseEntity.ok(transaction);
        } catch (TransactionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
        try {
            Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTransaction);
        } catch (TransactionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (InvalidTransactionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        try {
            transactionService.deleteTransaction(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (TransactionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
