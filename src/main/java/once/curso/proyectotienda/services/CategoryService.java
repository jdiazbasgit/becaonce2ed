package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entity.Category;
import once.curso.proyectotienda.repository.CategoryRepository;

@Service
@Data
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Iterable<Category> getCategory() {
		return getCategoryRepository().findAll();
	}

	public <S extends Category> S save(S entity) {

		return getCategoryRepository().save(entity);
	}

	public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {

		return getCategoryRepository().saveAll(entities);
	}

	public Optional<Category> findById(Integer id) {

		return getCategoryRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getCategoryRepository().existsById(id);
	}

	public Iterable<Category> findAll() {

		return getCategoryRepository().findAll();
	}

	public Iterable<Category> findAllById(Iterable<Integer> ids) {

		return getCategoryRepository().findAllById(ids);
	}

	public long count() {

		return getCategoryRepository().count();
	}

	public void deleteById(Integer id) {
		getCategoryRepository().deleteById(id);
	}

	public void delete(Category entity) {
		getCategoryRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCategoryRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Category> entities) {
		getCategoryRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCategoryRepository().deleteAll();
	}


}
