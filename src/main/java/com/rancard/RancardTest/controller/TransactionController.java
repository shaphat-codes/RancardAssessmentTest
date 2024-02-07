package com.rancard.RancardTest.controller;

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
        Transaction createdTransaction = transactionService.createTransaction(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @GetMapping
    public List<Transaction> getUsers(){
        return transactionService.getTransaction();
    }

    @GetMapping("/get")
    public Transaction getTransaction(@RequestParam Integer id){
        return transactionService.getTransaction(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction){
        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedTransaction);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id){
        transactionService.deleteTransaction(id);

        return ResponseEntity.noContent().build();
    }
}
