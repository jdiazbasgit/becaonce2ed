package once.curso.company.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.company.entities.Charge;
import once.curso.company.repositories.ChargeCRUDRepository;

@Service
@Data
public class ChargeService {

	@Autowired
	private ChargeCRUDRepository chargeCRUDRepository;

	public <S extends Charge> S save(S entity) {
		return getChargeCRUDRepository().save(entity);
	}

	public <S extends Charge> Iterable<S> saveAll(Iterable<S> entities) {
		return getChargeCRUDRepository().saveAll(entities);
	}

	public Optional<Charge> findById(Integer id) {
		return getChargeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getChargeCRUDRepository().existsById(id);
	}

	public Iterable<Charge> findAll() {
		return getChargeCRUDRepository().findAll();
	}

	public Iterable<Charge> findAllById(Iterable<Integer> ids) {
		return getChargeCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getChargeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getChargeCRUDRepository().deleteById(id);
	}

	public void delete(Charge entity) {
		getChargeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChargeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Charge> entities) {
		getChargeCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChargeCRUDRepository().deleteAll();
	}
}
