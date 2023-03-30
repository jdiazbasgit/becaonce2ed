package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.PersonalInformation;

@Repository
public interface PersonalInformationRepository extends CrudRepository<PersonalInformation, Integer> {


}
