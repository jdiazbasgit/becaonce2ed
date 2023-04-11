package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.Company;
@Repository
public interface CompanyCRUDRepository extends CrudRepository<Company, Integer> {

	
}
