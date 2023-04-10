package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.TransactionAwardFine;

@Repository
public interface TransactionAwardFineRepository extends CrudRepository<TransactionAwardFine, Integer> {

	
}
