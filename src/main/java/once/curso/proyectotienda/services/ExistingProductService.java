package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entitypes.ExistingProduct;
import once.curso.proyectotienda.repositories.ExistingProductCRUDRepository;

@Service
@Data
public class ExistingProductService {
	@Autowired
	private ExistingProductCRUDRepository existingProductsCRUDRepository;
	
	public <S extends ExistingProduct> S save(S entity) {
		return getExistingProductsCRUDRepository().save(entity);
	}

	public <S extends ExistingProduct> Iterable<S> saveAll(Iterable<S> entities) {
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

	public Iterable<ExistingProduct> findAllById(Iterable<Integer> ids) {
		return getExistingProductsCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getExistingProductsCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getExistingProductsCRUDRepository().deleteById(id);
	}

	public void delete(ExistingProduct entity) {
		getExistingProductsCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getExistingProductsCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends ExistingProduct> entities) {
		getExistingProductsCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getExistingProductsCRUDRepository().deleteAll();
	}
}
