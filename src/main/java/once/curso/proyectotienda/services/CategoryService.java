package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.repositories.CategoryCRUDRepository;

@Service
@Data
public class CategoryService {
	@Autowired
	private CategoryCRUDRepository categoryCRUDRepository;

	public Iterable<Category> getCategory() {
		return getCategoryCRUDRepository().findAll();
	}
	
	public Iterable<Category> saveAll(Iterable<Category> entities) {

		return getCategoryCRUDRepository().saveAll(entities);
	}

	public Category save(Category entity) {

		return getCategoryCRUDRepository().save(entity);
	}
	
	public Page<Category> findAll(Pageable pageable){
		return getCategoryCRUDRepository().findAll(pageable);
	}

	public Optional<Category> findById(Integer id) {

		return getCategoryCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getCategoryCRUDRepository().existsById(id);
	}

	public Iterable<Category> findAll() {

		return getCategoryCRUDRepository().findAll();
	}

	public Iterable<Category> findAllById(Iterable<Integer> ids) {

		return getCategoryCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getCategoryCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getCategoryCRUDRepository().deleteById(id);
	}

	public void delete(Category entity) {
		getCategoryCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCategoryCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Category> entities) {
		getCategoryCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCategoryCRUDRepository().deleteAll();
	}


}
