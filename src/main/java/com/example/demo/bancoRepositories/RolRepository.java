package com.example.demo.bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bancoEntityes.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

	

}
