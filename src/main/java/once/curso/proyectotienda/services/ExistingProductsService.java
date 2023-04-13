package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entitypes.ExistingProducts;
import once.curso.proyectotienda.repositories.ExistingProductsCRUDRepository;

@Service
@Data
public class ExistingProductsService {
	@Autowired
	private ExistingProductsCRUDRepository existingProductsCRUDRepository;
	
	public <S extends ExistingProducts> S save(S entity) {
		return getExistingProductsCRUDRepository().save(entity);
	}

	public <S extends ExistingProducts> Iterable<S> saveAll(Iterable<S> entities) {
		return getExistingProductsCRUDRepository().saveAll(entities);
	}

	public Optional<ExistingProducts> findById(Integer id) {
		return getExistingProductsCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getExistingProductsCRUDRepository().existsById(id);
	}

	public Iterable<ExistingProducts> findAll() {
		return getExistingProductsCRUDRepository().findAll();
	}

	public Iterable<ExistingProducts> findAllById(Iterable<Integer> ids) {
		return getExistingProductsCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getExistingProductsCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getExistingProductsCRUDRepository().deleteById(id);
	}

	public void delete(ExistingProducts entity) {
		getExistingProductsCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getExistingProductsCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends ExistingProducts> entities) {
		getExistingProductsCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getExistingProductsCRUDRepository().deleteAll();
	}
}
