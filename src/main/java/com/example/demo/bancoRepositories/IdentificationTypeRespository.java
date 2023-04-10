package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.IdentificationType;

@Repository
public interface IdentificationTypeRespository extends CrudRepository<IdentificationType, Integer> {


}
