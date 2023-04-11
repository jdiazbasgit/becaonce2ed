package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.SoldProduct;
import once.curso.proyectojpa.repositories.SoldProductReposistory;

@Data
@Service
public class SoldProductService {

	@Autowired
	private SoldProductReposistory soldProductReposistory;

	public void dameProductosVendidos() {

		Iterable<SoldProduct> dameProductosVendidos = getSoldProductReposistory().findAll();
		for (SoldProduct soldProduct : dameProductosVendidos) {
			System.out.println(soldProduct.getQuantity());
			System.out.println(soldProduct.getExistingProduct());
		}
	}

	public <S extends SoldProduct> S save(S entity) {
		return getSoldProductReposistory().save(entity);
	}

	public <S extends SoldProduct> Iterable<S> saveAll(Iterable<S> entities) {
		return getSoldProductReposistory().saveAll(entities);
	}

	public Optional<SoldProduct> findById(Integer id) {
		return getSoldProductReposistory().findById(id);
	}

	public boolean existsById(Integer id) {
		return getSoldProductReposistory().existsById(id);
	}

	public Iterable<SoldProduct> findAll() {
		return getSoldProductReposistory().findAll();
	}

	public Iterable<SoldProduct> findAllById(Iterable<Integer> ids) {
		return getSoldProductReposistory().findAllById(ids);
	}

	public long count() {
		return getSoldProductReposistory().count();
	}

	public void deleteById(Integer id) {
		getSoldProductReposistory().deleteById(id);
	}

	public void delete(SoldProduct entity) {
		getSoldProductReposistory().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getSoldProductReposistory().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends SoldProduct> entities) {
		getSoldProductReposistory().deleteAll(entities);
	}

	public void deleteAll() {
		getSoldProductReposistory().deleteAll();
	}
}
