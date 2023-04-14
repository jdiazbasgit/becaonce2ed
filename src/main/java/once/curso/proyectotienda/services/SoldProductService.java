package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.repositories.SoldProductCRUDRepository;

@Data
@Service
public class SoldProductService {

	@Autowired
	private SoldProductCRUDRepository soldProductCRUDRepository;

	public void dameProductoVendidos() {

	}

	public <S extends SoldProduct> S save(S entity) {
		return getSoldProductCRUDRepository().save(entity);
	}

	public <S extends SoldProduct> Iterable<S> saveAll(Iterable<S> entities) {
		return getSoldProductCRUDRepository().saveAll(entities);
	}

	public Optional<SoldProduct> findById(Integer id) {
		return getSoldProductCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getSoldProductCRUDRepository().existsById(id);
	}

	public Iterable<SoldProduct> findAll() {
		return getSoldProductCRUDRepository().findAll();
	}

	public Iterable<SoldProduct> findAllById(Iterable<Integer> ids) {
		return getSoldProductCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getSoldProductCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getSoldProductCRUDRepository().deleteById(id);
	}

	public void delete(SoldProduct entity) {
		getSoldProductCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getSoldProductCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends SoldProduct> entities) {
		getSoldProductCRUDRepository().deleteAll();
	}

	public void deleteAll() {
		getSoldProductCRUDRepository().deleteAll();
	}

}
