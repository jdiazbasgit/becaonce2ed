package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.AwardFine;

@Repository
public interface AwardFineRepository extends CrudRepository<AwardFine, Integer> {

	
}