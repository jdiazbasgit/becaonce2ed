package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {



}
