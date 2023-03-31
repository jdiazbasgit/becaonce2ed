package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

	

	
}
