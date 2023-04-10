package once.curso.proyectobancojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobancojpa.entities.Description;
import once.curso.proyectobancojpa.repositories.DescriptionRepository;

@Service
@Data
public class DescriptionService {

	@Autowired
	private DescriptionRepository descriptionRepository;

	public void dameDescriptions() {

		Iterable<Description> descriptions = getDescriptionRepository().findAll();
		for (Description description : descriptions) {
			System.out.println(description.getDescription());

		}
	}

	public <S extends Description> S save(S entity) {

		return getDescriptionRepository().save(entity);
	}

	public <S extends Description> Iterable<S> saveAll(Iterable<S> entities) {

		return getDescriptionRepository().saveAll(entities);
	}

	public Optional<Description> findById(Integer id) {

		return getDescriptionRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getDescriptionRepository().existsById(id);
	}

	public Iterable<Description> findAll() {

		return getDescriptionRepository().findAll();
	}

	public Iterable<Description> findAllById(Iterable<Integer> ids) {

		return getDescriptionRepository().findAllById(ids);
	}

	public long count() {

		return getDescriptionRepository().count();
	}

	public void deleteById(Integer id) {
		getDescriptionRepository().deleteById(id);

	}

	public void delete(Description entity) {
		getDescriptionRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getDescriptionRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends Description> entities) {
		getDescriptionRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getDescriptionRepository().deleteAll();

	}
}
