package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.Charge;
@Repository
public interface ChargeCRUDRepository extends CrudRepository<Charge, Integer> {

	
}
