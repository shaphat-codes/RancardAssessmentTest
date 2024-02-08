package com.rancard.RancardTest.service.Impl;

import com.rancard.RancardTest.Exception.InvalidTransactionException;
import com.rancard.RancardTest.Exception.TransactionNotFoundException;
import com.rancard.RancardTest.entity.Transaction;
import com.rancard.RancardTest.repository.TransactionRepository;
import com.rancard.RancardTest.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        log.info("Creating transaction: {}", transaction);

        if (transaction == null || transaction.getAmount() <= 0) {
            log.error("Transaction creation was unsuccessful: {}", transaction);
            throw new InvalidTransactionException("Invalid transaction data");
        }

        Transaction createdTransaction = transactionRepository.save(transaction);
        log.info("Transaction created: {}", createdTransaction);
        return createdTransaction;
    }

    @Override
    public List<Transaction> getTransaction() {
        log.info("Fetching all transactions");
        List<Transaction> transactions = transactionRepository.findAll();
        log.info("Fetched {} transactions", transactions.size());
        return transactions;
    }
    @Override
    public Transaction getTransaction(Integer id) {
        log.info("Getting transaction with ID: {}", id);
        Transaction transaction = transactionRepository
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction with ID " + id + " not found"));
        log.info("Transaction with ID {} fetched successfully", id);
        return transaction;
    }

    @Override
    public Transaction updateTransaction(Integer id, Transaction transaction) {
        log.info("Updating transaction with ID: {}", id);
        transactionRepository
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction with ID " + id + " not found"));

        if (transaction == null || transaction.getAmount() <= 0) {
            throw new InvalidTransactionException("Invalid transaction data");
        }

        transaction.setId(id);

        log.info("Transaction with ID {} updated successfully", id);

        return transactionRepository.save(transaction);


    }

    @Override
    public void deleteTransaction(Integer id) {
        log.info("Deleting transaction with ID: {}", id);

        Transaction transaction = transactionRepository
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction with ID " + id + " not found"));
        transactionRepository.delete(transaction);

        log.info("Transaction with ID {} deleted successfully", id);
    }

}
