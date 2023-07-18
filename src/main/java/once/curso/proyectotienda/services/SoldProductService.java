package once.curso.proyectotienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.repositories.SoldProductCRUDRepository;

@Data
@Service
public class SoldProductService {

	@Autowired
	private SoldProductCRUDRepository soldProductCRUDRepository;

	public Iterable<SoldProduct> getSoldproduct() {
		return getSoldProductCRUDRepository().findAll();
	}

	public SoldProduct save(SoldProduct entity) {
		return getSoldProductCRUDRepository().save(entity);
	}

	public Iterable<SoldProduct> saveAll(Iterable<SoldProduct> entities) {
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

	public Page<SoldProduct> findAll(Pageable pageable){
		return getSoldProductCRUDRepository().findAll(pageable);
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

	public List<SoldProduct> findAllbyName(String user) {
		return getSoldProductCRUDRepository().findAllbyName(user);
	}

}
