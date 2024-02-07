package com.rancard.RancardTest.service.Impl;

import com.rancard.RancardTest.entity.Transaction;
import com.rancard.RancardTest.repository.TransactionRepository;
import com.rancard.RancardTest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Integer id) {
        Transaction transaction = transactionRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid transaction id"+id));
        return transaction;
    }

    @Override
    public Transaction updateTransaction(Integer id, Transaction transaction) {
        transactionRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid transaction id "+ id));
        transaction.setId(id);

        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Integer id) {
        Transaction transaction = transactionRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid transaction id"+id));
        transactionRepository.delete(transaction);
    }

}
