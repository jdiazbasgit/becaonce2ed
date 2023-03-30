package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Company;

@Repository
public interface CompanyCRUDRepository extends CrudRepository<Company, Integer> {

}
