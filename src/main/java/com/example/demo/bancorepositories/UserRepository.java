package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {



}
