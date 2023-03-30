package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Children;

@Repository
public interface ChildrenCRUDRepository extends CrudRepository<Children, Integer> {


}
