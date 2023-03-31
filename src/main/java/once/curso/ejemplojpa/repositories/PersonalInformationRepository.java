package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.PersonalInformation;

public interface PersonalInformationRepository extends CrudRepository<PersonalInformation, Integer> {

	

	
}
