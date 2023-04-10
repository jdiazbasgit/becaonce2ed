package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.Configuration;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {

	
}
