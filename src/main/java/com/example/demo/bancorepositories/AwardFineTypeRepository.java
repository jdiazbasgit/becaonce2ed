package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.AwardFineType;

@Repository
public interface AwardFineTypeRepository extends CrudRepository<AwardFineType,Integer> {


}
