package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.LaboralInformation;
@Repository
public interface LaboralInformationCRUDRepository extends CrudRepository<LaboralInformation, Integer> {

	
}
