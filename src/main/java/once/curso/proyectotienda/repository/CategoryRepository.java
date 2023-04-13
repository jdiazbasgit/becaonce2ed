package once.curso.proyectotienda.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entity.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	

}
