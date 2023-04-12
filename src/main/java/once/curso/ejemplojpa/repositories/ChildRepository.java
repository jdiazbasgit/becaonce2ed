package once.curso.ejemplojpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Child;


public interface ChildRepository extends CrudRepository<Child, Integer> {

	//@Query("from company where children.id> :cantidad ")
	//public List<Child> getChildrens(int cantidad);
	

}
