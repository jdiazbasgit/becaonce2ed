package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	
}
