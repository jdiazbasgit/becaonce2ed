package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.MaritalStatus;

public interface MaritalStatusCrudRepository extends CrudRepository<MaritalStatus, Integer> {
	
}
