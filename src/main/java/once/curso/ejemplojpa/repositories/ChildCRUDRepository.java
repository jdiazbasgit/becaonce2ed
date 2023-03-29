package once.curso.ejemplojpa.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entities.Child;

@Repository
public interface ChildCRUDRepository extends CrudRepository<Child, Integer> {	
}
