package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bancoentityes.Fee;

public interface FeeRepository extends CrudRepository<Fee,Integer> {

	
}
