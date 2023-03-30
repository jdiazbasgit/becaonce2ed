package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Child;

@Repository
public interface ChildRepository extends CrudRepository<Child,Integer> {

	
	
	
	/*@Query(value = "select c.description from children c where c.descripcion like :filtro",nativeQuery = true)
	public String[] dameChildren(String filtro);*/

}
