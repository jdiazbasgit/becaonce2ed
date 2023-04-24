package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.repositories.SubCategoryCRUDRepository;

@Service
@Data
public class SubcategoryService {

	@Autowired
	private SubCategoryCRUDRepository subCategoryRepository;

	public SubCategory save(SubCategory entity) {
		return getSubCategoryRepository().save(entity);
	}

	public Iterable<SubCategory> saveAll(Iterable<SubCategory> entities) {
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
