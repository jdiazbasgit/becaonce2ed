package once.curso.proyectotienda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.SubCategory;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Integer> {
	
}
