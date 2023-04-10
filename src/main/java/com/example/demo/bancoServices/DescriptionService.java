package bancoServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bancoEntityes.Description;
import bancoRepositories.DescriptionRepository;
import lombok.Data;

@Data
@Service
public class DescriptionService {
	
	@Autowired
	private DescriptionRepository descriptionRepository;
	
	public void dameDescripcion() {
		Iterable<Description> descripcion= getDescriptionRepository().findAll();
		for (Description description : descripcion) {
			System.out.println(description.getDescription());
			
		}
	}
	public long count() {
		return getDescriptionRepository().count();
	}

	public void delete(Description entity) {
		getDescriptionRepository().delete(entity);
	}

	public void deleteAll() {
		getDescriptionRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends Description> entities) {
		getDescriptionRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getDescriptionRepository().deleteAllById(ids);
	}

	public void deleteById(Integer id) {
		getDescriptionRepository().deleteById(id);
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

	public Optional<Description> findById(Integer id) {
		return getDescriptionRepository().findById(id);
	}

	public <S extends Description> S save(S entity) {
		return getDescriptionRepository().save(entity);
	}

	public <S extends Description> Iterable<S> saveAll(Iterable<S> entities) {
		return getDescriptionRepository().saveAll(entities);
	}

}
