package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.repositories.AwardFineCRUDRepositories;

@Service
@Data
public class AwardFineServices {

	@Autowired
	private AwardFineCRUDRepositories awardFineCRUDRepositories;

	public void dameTipoPremiosMultas() {

		Iterable<AwardFine> TipoPremiosMultas = getAwardFineCRUDRepositories().findAll();
		for (AwardFine awardFine : TipoPremiosMultas) {
			// System.out.println(awardFine.getAwrdFineType());
			// System.out.println(awardFine.getAwardFieConfiguration());
			// System.out.println(awardFine.getTime());
		}
	}

	public <S extends AwardFine> S save(S entity) {

		return getAwardFineCRUDRepositories().save(entity);
	}

	public <S extends AwardFine> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineCRUDRepositories().saveAll(entities);
	}

	public Optional<AwardFine> findById(Integer id) {

		return getAwardFineCRUDRepositories().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineCRUDRepositories().existsById(id);
	}

	public Iterable<AwardFine> findAll() {

		return getAwardFineCRUDRepositories().findAll();
	}

	public Iterable<AwardFine> findAllById(Iterable<Integer> ids) {

		return getAwardFineCRUDRepositories().findAllById(ids);
	}

	public long count() {

		return getAwardFineCRUDRepositories().count();
	}

	public void deleteById(Integer id) {
		getAwardFineCRUDRepositories().deleteById(id);

	}

	public void delete(AwardFine entity) {
		getAwardFineCRUDRepositories().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineCRUDRepositories().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFine> entities) {
		getAwardFineCRUDRepositories().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineCRUDRepositories().deleteAll();

	}
}
