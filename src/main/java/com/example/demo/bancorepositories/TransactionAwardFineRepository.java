package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.TransactionAwardFine;

@Repository
public interface TransactionAwardFineRepository extends CrudRepository<TransactionAwardFine, Integer> {

	
}
