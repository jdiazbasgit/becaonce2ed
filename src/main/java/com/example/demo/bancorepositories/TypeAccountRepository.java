package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.TypeAccount;

@Repository
public interface TypeAccountRepository extends CrudRepository<TypeAccount, Integer> {

	
}
