package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.IdentificationType;

@Repository
public interface IdentificationTypeRespository extends CrudRepository<IdentificationType, Integer> {


}
