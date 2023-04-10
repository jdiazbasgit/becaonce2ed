package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	

}
