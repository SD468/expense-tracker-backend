package com.expanse.tracker.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expanse.tracker.entity.Transaction;

@Repository
public interface TransactionRepos extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
