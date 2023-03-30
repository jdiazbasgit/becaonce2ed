package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.LaboralInformation;

@Repository
public interface LaboralInformationCRUDRepository extends CrudRepository<LaboralInformation, Integer>{

	
	

}

