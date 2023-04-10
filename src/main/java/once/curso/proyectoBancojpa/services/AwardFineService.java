package once.curso.proyectoBancojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectoBancojpa.entities.AwardFine;
import once.curso.proyectoBancojpa.repositories.AwardFineRepository;

@Service
@Data
public class AwardFineService {

	@Autowired
	private AwardFineRepository awardFineRepository;

	public void dameTipoPremiosMultas() {

		Iterable<AwardFine> TipoPremiosMultas = getAwardFineRepository().findAll();
		for (AwardFine awardFine : TipoPremiosMultas) {
			System.out.println(awardFine.getAwardFineType());
			System.out.println(awardFine.getAwardFieConfiguration());
			System.out.println(awardFine.getTime());
			
		}
	}

	public <S extends AwardFine> S save(S entity) {

		return getAwardFineRepository().save(entity);
	}

	public <S extends AwardFine> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineRepository().saveAll(entities);
	}

	public Optional<AwardFine> findById(Integer id) {

		return getAwardFineRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineRepository().existsById(id);
	}

	public Iterable<AwardFine> findAll() {

		return getAwardFineRepository().findAll();
	}

	public Iterable<AwardFine> findAllById(Iterable<Integer> ids) {

		return getAwardFineRepository().findAllById(ids);
	}

	public long count() {

		return getAwardFineRepository().count();
	}

	public void deleteById(Integer id) {
		getAwardFineRepository().deleteById(id);

	}

	public void delete(AwardFine entity) {
		getAwardFineRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFine> entities) {
		getAwardFineRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineRepository().deleteAll();

	}
}
