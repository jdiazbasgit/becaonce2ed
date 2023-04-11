package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.ExistingProduct;
import once.curso.proyectojpa.repositories.ExistingProductRepository;

@Data
@Service
public class ExistingProductService {

	@Autowired
	private ExistingProductRepository existingProductRepository;

	public void dameProductosExistentes() {

		Iterable<ExistingProduct> dameProductosExistentes = getExistingProductRepository().findAll();
		for (ExistingProduct existingProduct : dameProductosExistentes) {

			System.out.println(existingProduct.getDescription());
			System.out.println(existingProduct.getPrice());
			System.out.println(existingProduct.getStock());
			System.out.println(existingProduct.getImage());
			System.out.println(existingProduct.getSubCategory());
		}

	}

	public <S extends ExistingProduct> S save(S entity) {
		return getExistingProductRepository().save(entity);
	}

	public <S extends ExistingProduct> Iterable<S> saveAll(Iterable<S> entities) {
		return getExistingProductRepository().saveAll(entities);
	}

	public Optional<ExistingProduct> findById(Integer id) {
		return getExistingProductRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getExistingProductRepository().existsById(id);
	}

	public Iterable<ExistingProduct> findAll() {
		return getExistingProductRepository().findAll();
	}

	public Iterable<ExistingProduct> findAllById(Iterable<Integer> ids) {
		return getExistingProductRepository().findAllById(ids);
	}

	public long count() {
		return getExistingProductRepository().count();
	}

	public void deleteById(Integer id) {
		getExistingProductRepository().deleteById(id);
	}

	public void delete(ExistingProduct entity) {
		getExistingProductRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getExistingProductRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends ExistingProduct> entities) {
		getExistingProductRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getExistingProductRepository().deleteAll();
	}
}
