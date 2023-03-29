package once.curso.ejemplojpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.entityes.Child;


public interface ChildrenRepository extends CrudRepository<Child,Integer> {
	
	@Query(value = "select c.description from children c where c.descriopcion like :filtro",nativeQuery = true)
	public String[] dameChildren(String filtro);

}
