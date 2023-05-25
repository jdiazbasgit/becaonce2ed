package once.curso.proyectotienda.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectotienda.entities.SubCategory;

@Repository
public interface SubCategoryCRUDRepository extends PagingAndSortingRepository<SubCategory, Integer> {
	
}
