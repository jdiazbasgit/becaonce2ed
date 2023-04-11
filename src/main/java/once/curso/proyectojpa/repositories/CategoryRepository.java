package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import once.curso.proyectojpa.entities.Category;

@Service
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
