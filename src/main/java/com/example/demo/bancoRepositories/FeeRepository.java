package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bancoEntityes.Fee;

public interface FeeRepository extends CrudRepository<Fee,Integer> {

	
}
