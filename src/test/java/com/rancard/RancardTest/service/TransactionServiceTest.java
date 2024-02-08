package com.rancard.RancardTest.service;

import com.rancard.RancardTest.Exception.TransactionNotFoundException;
import com.rancard.RancardTest.entity.Transaction;
import com.rancard.RancardTest.entity.User;
import com.rancard.RancardTest.repository.TransactionRepository;
import com.rancard.RancardTest.service.Impl.TransactionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    // Other dependencies if any

    @Test
    public void testCreateTransaction_Success() {
        // Arrange

        Transaction transaction = new Transaction();
        transaction.setSender(new User("John Doe", 30, "123 Main St"));
        transaction.setReceiver(new User("Jane Smith", 25, "456 Elm St"));
        transaction.setAmount(100.00);
        transaction.setTransactionDate(new Date()); // Use current date/time

        // Mock behavior of the repository
        when(transactionRepository.save(any())).thenReturn(transaction);

        // Act
        Transaction createdTransaction = transactionService.createTransaction(transaction);

        // Assert
        assertNotNull(createdTransaction);

    }


    @Test(expected = TransactionNotFoundException.class)
    public void testGetTransaction_TransactionNotFound() {
        // Arrange
        int nonExistentId = 999;
        when(transactionRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act
        transactionService.getTransaction(nonExistentId);

        // Assert:
    }


    @Test
    public void testUpdateTransaction_Interactions() {
        // Arrange
        int id = 3;
        Transaction transaction = new Transaction();
        transaction.setSender(new User("John Doe", 30, "123 Main St"));
        transaction.setReceiver(new User("Jane Smith", 25, "456 Elm St"));
        transaction.setAmount(100.00);
        transaction.setTransactionDate(new Date()); // Use current date/time

        // Mock behavior of the repository
        when(transactionRepository.findById(id)).thenReturn(Optional.of(transaction));

        // Act
        transactionService.updateTransaction(id, transaction);

        // Assert
        verify(transactionRepository).findById(id);
        verify(transactionRepository).save(transaction);
    }





}
