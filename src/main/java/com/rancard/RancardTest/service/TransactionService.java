package com.rancard.RancardTest.service;

import com.rancard.RancardTest.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);

    List<Transaction> getTransaction();

    Transaction getTransaction(Integer id);

    Transaction updateTransaction(Integer id, Transaction transaction);

    void deleteTransaction(Integer id);
}
