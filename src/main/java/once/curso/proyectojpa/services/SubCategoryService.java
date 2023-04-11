package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.SubCategory;
import once.curso.proyectojpa.repositories.SubCategoryRepository;

@Data
@Service
public class SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public void damesubCat() {

		Iterable<SubCategory> dameSubCat = getSubCategoryRepository().findAll();
		for (SubCategory subCategory : dameSubCat) {
			System.out.println(subCategory.getDescription());
			System.out.println(subCategory.getCategory());
		}
	}

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
		getSubCategoryRepository().delete(entity);
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
