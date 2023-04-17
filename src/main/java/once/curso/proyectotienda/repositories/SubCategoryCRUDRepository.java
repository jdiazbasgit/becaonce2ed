package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.SubCategory;

@Repository
public interface SubCategoryCRUDRepository extends CrudRepository<SubCategory, Integer> {
	
}
