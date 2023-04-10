package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.AwardFine;

@Repository
public interface AwardFineRepository extends CrudRepository<AwardFine, Integer> {

	
}
