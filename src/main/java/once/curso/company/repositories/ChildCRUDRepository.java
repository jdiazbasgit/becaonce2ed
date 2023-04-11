package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.Child;
@Repository
public interface ChildCRUDRepository extends CrudRepository<Child, Integer> {

	
}
