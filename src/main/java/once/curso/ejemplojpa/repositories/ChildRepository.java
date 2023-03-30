package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Child;

@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {

	
	
	

}
