package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	

}
