package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.repositories.AwardFineCRUDRepositories;

@Service
@Data
public class AwardsFinesServices {

	@Autowired
	private AwardFineCRUDRepositories awardFineCRUDRepositories;

	public void dameTipoPremiosMultas() {

		// Iterable<AwardsFine> TipoPremiosMultas =
		// getAwardFineCRUDRepositories().findAll();
		// for (AwardsFine awardFine : TipoPremiosMultas) {
		// System.out.println(awardFine.getAwrdFineType());
		// System.out.println(awardFine.getAwardFieConfiguration());
		// System.out.println(awardFine.getTime());
	}

	public <S extends AwardsFine> S save(S entity) {

		return getAwardFineCRUDRepositories().save(entity);
	}

	public <S extends AwardsFine> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineCRUDRepositories().saveAll(entities);
	}

	public Optional<AwardsFine> findById(Integer id) {

		return getAwardFineCRUDRepositories().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineCRUDRepositories().existsById(id);
	}

	public Iterable<AwardsFine> findAll() {

		return getAwardFineCRUDRepositories().findAll();
	}

	public Iterable<AwardsFine> findAllById(Iterable<Integer> ids) {

		return getAwardFineCRUDRepositories().findAllById(ids);
	}

	public long count() {

		return getAwardFineCRUDRepositories().count();
	}

	public void deleteById(Integer id) {
		getAwardFineCRUDRepositories().deleteById(id);

	}

	public void delete(AwardsFine entity) {
		getAwardFineCRUDRepositories().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineCRUDRepositories().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardsFine> entities) {
		getAwardFineCRUDRepositories().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineCRUDRepositories().deleteAll();

	}

}
