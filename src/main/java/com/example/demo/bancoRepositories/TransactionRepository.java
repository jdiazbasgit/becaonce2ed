package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	
}
