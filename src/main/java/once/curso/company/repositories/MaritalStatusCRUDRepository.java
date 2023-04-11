package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.MaritalStatus;
@Repository
public interface MaritalStatusCRUDRepository extends CrudRepository<MaritalStatus, Integer> {

	
}
