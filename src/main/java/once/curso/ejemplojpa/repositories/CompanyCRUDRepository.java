package once.curso.ejemplojpa.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entities.Company;

@Repository
public interface CompanyCRUDRepository extends CrudRepository<Company, Integer> {	
}
