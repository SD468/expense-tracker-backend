package com.expanse.tracker.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expanse.tracker.entity.Transaction;
import com.expanse.tracker.repos.TransactionRepos;
import com.expanse.tracker.utils.DateUtils;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private final TransactionRepos transactionRepos;
	
	@Autowired
    public TransactionServiceImpl(TransactionRepos transactionRepos) {
        this.transactionRepos = transactionRepos;
    }
	
	 public List<Transaction> getTransactionsForMonth(int year, int month) {
	        YearMonth yearMonth = YearMonth.of(year, month);
	        LocalDate startDate = yearMonth.atDay(1); 
	        LocalDate endDate = yearMonth.atEndOfMonth(); 
	        return transactionRepos.findByDateBetween(startDate, endDate);
	    }

	@Override
	public List<Transaction> getTransactionsBetweenDates(String startDate, String endDate) {
		
		return transactionRepos.findByDateBetween(DateUtils.toLocalDate(startDate), DateUtils.toLocalDate(endDate));
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepos.findAll();
	}

	@Override
	public void save(Transaction transaction) {
		transactionRepos.save(transaction);
		
	}

}
