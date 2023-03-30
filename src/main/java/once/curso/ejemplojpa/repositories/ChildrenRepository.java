package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Child;


public class ChildrenRepository {

	@Repository
	public interface ChildRepository extends CrudRepository<Child, Integer> {


	}
}
