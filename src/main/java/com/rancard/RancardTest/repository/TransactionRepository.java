package com.rancard.RancardTest.repository;

import com.rancard.RancardTest.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
