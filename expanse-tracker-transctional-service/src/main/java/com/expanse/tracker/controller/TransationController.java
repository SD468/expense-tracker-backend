package com.expanse.tracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expanse.tracker.entity.Transaction;
import com.expanse.tracker.service.TransactionService;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin(origins = "http://localhost:5173")
public class TransationController {
	
	@Autowired
	private  TransactionService transactionService;
	
	@PostMapping("/save")
	public void saveTransactions(@RequestBody Transaction transaction) {
		transactionService.save(transaction);
		
	}
	
	@GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
	
	@GetMapping("/DateRange")
    public List<Transaction> getTransactionsBetweenDates(
            @RequestParam String start,
            @RequestParam String end) {
        return transactionService.getTransactionsBetweenDates(start, end);
    }
	
	@GetMapping("/month")
	public List<Transaction> getTransactionsForMonth(
	        @RequestParam int year,
	        @RequestParam int month) {
	    return transactionService.getTransactionsForMonth(year, month);
	}

}
