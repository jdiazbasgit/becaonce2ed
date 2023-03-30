package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.PersonalInformation;

public class PersonalInformationRepostory {


	@Repository
	public interface PersonalInformationRepository extends CrudRepository<PersonalInformation, Integer> {
	}

}
