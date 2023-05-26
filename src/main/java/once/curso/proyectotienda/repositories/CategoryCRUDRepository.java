package once.curso.proyectotienda.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectotienda.entities.Category;


@Repository
public interface CategoryCRUDRepository extends PagingAndSortingRepository<Category, Integer> {

	

}
