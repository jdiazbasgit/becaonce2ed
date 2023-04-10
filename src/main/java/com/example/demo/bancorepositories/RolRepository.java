package com.example.demo.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoentityes.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

	

}
