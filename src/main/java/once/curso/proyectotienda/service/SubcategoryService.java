package once.curso.proyectotienda.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.repository.SubCategoryRepository;

@Service
@Data
public class SubcategoryService {

	private SubCategoryRepository subCategoryRepository;

	public <S extends SubCategory> S save(S entity) {

		return getSubCategoryRepository().save(entity);
	}

	public <S extends SubCategory> Iterable<S> saveAll(Iterable<S> entities) {

		return getSubCategoryRepository().saveAll(entities);
	}

	public Optional<SubCategory> findById(Integer id) {

		return getSubCategoryRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getSubCategoryRepository().existsById(id);
	}

	public Iterable<SubCategory> findAll() {

		return getSubCategoryRepository().findAll();
	}

	public Iterable<SubCategory> findAllById(Iterable<Integer> ids) {

		return getSubCategoryRepository().findAllById(ids);
	}

	public long count() {

		return getSubCategoryRepository().count();
	}

	public void deleteById(Integer id) {
		getSubCategoryRepository().deleteById(id);
	}

	public void delete(SubCategory entity) {
		getSubCategoryRepository().deleteAll();
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getSubCategoryRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends SubCategory> entities) {
		getSubCategoryRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getSubCategoryRepository().deleteAll();
	}
}
