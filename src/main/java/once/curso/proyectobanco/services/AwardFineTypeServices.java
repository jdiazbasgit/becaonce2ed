package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.repositories.AwardFineTypeCRUDRepositories;

@Service
@Data
public class AwardFineTypeServices {

	@Autowired
	private AwardFineTypeCRUDRepositories awardFineTypeCRUDRepositories;

	public void dameAwardFineType() {

		Iterable<AwardFineType> awardsFinesTypes = getAwardFineTypeCRUDRepositories().findAll();
		for (AwardFineType awardFineType : awardsFinesTypes) {
			//System.out.println(awardFineType.getDescription());
		}
	}

	public <S extends AwardFineType> S save(S entity) {

		return getAwardFineTypeCRUDRepositories().save(entity);
	}

	public <S extends AwardFineType> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineTypeCRUDRepositories().saveAll(entities);
	}

	public Optional<AwardFineType> findById(Integer id) {

		return getAwardFineTypeCRUDRepositories().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineTypeCRUDRepositories().existsById(id);
	}

	public Iterable<AwardFineType> findAll() {

		return getAwardFineTypeCRUDRepositories().findAll();
	}

	public Iterable<AwardFineType> findAllById(Iterable<Integer> ids) {

		return getAwardFineTypeCRUDRepositories().findAllById(ids);
	}

	public long count() {

		return getAwardFineTypeCRUDRepositories().count();
	}

	public void deleteById(Integer id) {
		getAwardFineTypeCRUDRepositories().deleteById(id);

	}

	public void delete(AwardFineType entity) {
		getAwardFineTypeCRUDRepositories().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineTypeCRUDRepositories().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFineType> entities) {
		getAwardFineTypeCRUDRepositories().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineTypeCRUDRepositories().deleteAll();

	}

}
