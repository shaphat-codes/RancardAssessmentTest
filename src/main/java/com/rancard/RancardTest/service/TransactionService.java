package com.rancard.RancardTest.service;

import com.rancard.RancardTest.entity.Transaction;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);

    Page<Transaction> getTransactions(int page, int size);

    Transaction getTransaction(Integer id);

    Transaction updateTransaction(Integer id, Transaction transaction);

    void deleteTransaction(Integer id);
}
