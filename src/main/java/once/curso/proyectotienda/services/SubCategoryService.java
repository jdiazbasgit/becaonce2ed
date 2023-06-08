package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.repositories.SubCategoryCRUDRepository;

@Service
@Data
public class SubCategoryService {

	@Autowired
	private SubCategoryCRUDRepository subCategoryCRUDRepository;

	public SubCategory save(SubCategory entity) {

		return getSubCategoryCRUDRepository().save(entity);
	}

	public  Iterable<SubCategory> saveAll(Iterable<SubCategory> entities) {

		return getSubCategoryCRUDRepository().saveAll(entities);
	}

	public Optional<SubCategory> findById(Integer id) {

		return getSubCategoryCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getSubCategoryCRUDRepository().existsById(id);
	}
	
	public Page<SubCategory> findAll(Pageable pageable){
		return getSubCategoryCRUDRepository().findAll(pageable);
		}

	public Iterable<SubCategory> findAll() {
		return getSubCategoryCRUDRepository().findAll();
	}

	public Iterable<SubCategory> findAllById(Iterable<Integer> ids) {

		return getSubCategoryCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getSubCategoryCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getSubCategoryCRUDRepository().deleteById(id);
	}

	public void delete(SubCategory entity) {
		getSubCategoryCRUDRepository().deleteAll();
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getSubCategoryCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends SubCategory> entities) {
		getSubCategoryCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getSubCategoryCRUDRepository().deleteAll();
	}
}
