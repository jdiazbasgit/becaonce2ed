package once.curso.proyectotienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.repositories.ExistingProductCRUDRepository;

@Service
@Data
public class ExistingProductService {
	@Autowired
	private ExistingProductCRUDRepository existingProductsCRUDRepository;
	
	public ExistingProduct save(ExistingProduct entity) {
		return getExistingProductsCRUDRepository().save(entity);
	}

	public Iterable<ExistingProduct> saveAll(Iterable<ExistingProduct> entities) { //*
		return getExistingProductsCRUDRepository().saveAll(entities);
	}

	public Optional<ExistingProduct> findById(Integer id) {
		return getExistingProductsCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getExistingProductsCRUDRepository().existsById(id);
	}

	public Iterable<ExistingProduct> findAll() {
		return getExistingProductsCRUDRepository().findAll();
	}
	
	public Page<ExistingProduct> findAll(Pageable pageable){
		return getExistingProductsCRUDRepository().findAll(pageable);
		}

	public Iterable<ExistingProduct> findAllById(Iterable<Integer> ids) { //*
		return getExistingProductsCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getExistingProductsCRUDRepository().count();
	}

	public Object deleteById(Integer id) {
		getExistingProductsCRUDRepository().deleteById(id);
		return id;
	}
	
	public void delete(ExistingProduct entity) {
		getExistingProductsCRUDRepository().delete(entity);
	}
	
	public void deleteAll(Iterable<? extends ExistingProduct> entities) {
		getExistingProductsCRUDRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		for (Integer id : ids){getExistingProductsCRUDRepository().deleteById(id);}
	}

	public void deleteAll() {
		getExistingProductsCRUDRepository().deleteAll();
	}
	
	public List<ExistingProduct> getExistingProductByCategory(int categoryId){
		return getExistingProductsCRUDRepository().getExistingProductByCategory(categoryId);
	}
	
	//public List<ExistingProduct> getExistingProductsBySubcategory(int subcategoryId);
}
