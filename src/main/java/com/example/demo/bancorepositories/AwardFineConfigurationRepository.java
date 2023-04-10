package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.AwardFineConfiguration;

@Repository
public interface AwardFineConfigurationRepository extends CrudRepository<AwardFineConfiguration, Integer> {

	

}
