package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.TypeAccount;

@Repository
public interface TypeAccountRepository extends CrudRepository<TypeAccount, Integer> {

	
}
