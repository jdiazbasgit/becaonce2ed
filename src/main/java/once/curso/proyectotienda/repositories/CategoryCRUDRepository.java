package once.curso.proyectotienda.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Category;


@Repository
public interface CategoryCRUDRepository extends CrudRepository<Category, Integer> {

	

}
