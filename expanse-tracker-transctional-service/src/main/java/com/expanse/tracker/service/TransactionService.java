package com.expanse.tracker.service;

import java.time.LocalDate;
import java.util.List;

import com.expanse.tracker.entity.Transaction;


public interface TransactionService {

	List<Transaction> getTransactionsForMonth(int year, int month);

	List<Transaction> getTransactionsBetweenDates(LocalDate start, LocalDate end);

	List<Transaction> getAllTransactions();

	void save(Transaction transaction);

}
