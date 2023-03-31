package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.MaritalStatus;

public interface MaritalStatusRepository extends CrudRepository<MaritalStatus, Integer> {

	
}
