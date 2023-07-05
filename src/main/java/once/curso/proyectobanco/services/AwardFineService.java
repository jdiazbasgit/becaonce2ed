package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.repositories.AwardFineCRUDRepository;

@Service
@Data
public class AwardFineService {

	@Autowired
	private AwardFineCRUDRepository awardFineCRUDRepository;

	public void dameTipoPremiosMultas() {

		// Iterable<AwardsFine> TipoPremiosMultas =
		// getAwardFineCRUDRepositories().findAll();
		// for (AwardsFine awardFine : TipoPremiosMultas) {
		// System.out.println(awardFine.getAwrdFineType());
		// System.out.println(awardFine.getAwardFieConfiguration());
		// System.out.println(awardFine.getTime());
	}

	public <S extends AwardFine> S save(S entity) {

		return getAwardFineCRUDRepository().save(entity);
	}

	public <S extends AwardFine> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineCRUDRepository().saveAll(entities);
	}

	public Optional<AwardFine> findById(Integer id) {

		return getAwardFineCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineCRUDRepository().existsById(id);
	}

	public Iterable<AwardFine> findAll() {

		return getAwardFineCRUDRepository().findAll();
	}
	
	public Page<AwardFine> findAll(Pageable pageable) {

		return getAwardFineCRUDRepository().findAll(pageable);
	}

	public Iterable<AwardFine> findAllById(Iterable<Integer> ids) {

		return getAwardFineCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getAwardFineCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getAwardFineCRUDRepository().deleteById(id);

	}

	public void delete(AwardFine entity) {
		getAwardFineCRUDRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineCRUDRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFine> entities) {
		getAwardFineCRUDRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineCRUDRepository().deleteAll();

	}

}
