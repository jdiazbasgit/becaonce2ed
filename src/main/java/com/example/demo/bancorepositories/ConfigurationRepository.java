package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.Configuration;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {

	
}
