package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.PersonalInformation;
@Repository
public interface PersonalInformationCRUDRepository extends CrudRepository<PersonalInformation, Integer> {

	
}
