package once.curso.ejemplojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.repositories.ChargeRepository;

@Service
@Data
public class ChargeService {

	@Autowired
	private ChargeRepository chargeRepository;

	public void dameCargos() {

		Iterable<Charge> cargos = getChargeRepository().findAll();
		for (Charge charge : cargos) {
			System.out.println(charge.getDescription());
		}
	}

	public String[] dameCargosQueEmpiecenPor(String filtro) {
		return getChargeRepository().dameCargosQueEmpiecenPor(filtro);
	}

	public <S extends Charge> S save(S entity) {

		return getChargeRepository().save(entity);
	}

	public <S extends Charge> Iterable<S> saveAll(Iterable<S> entities) {

		return get
	}

	public Optional<Charge> findById(Integer id) {

		return null;
	}

	public boolean existsById(Integer id) {

		return false;
	}

	public Iterable<Charge> findAll() {

		return null;
	}

	public Iterable<Charge> findAllById(Iterable<Integer> ids) {

		return null;
	}

	public long count() {

		return 0;
	}

	public void deleteById(Integer id) {

	}

	public void delete(Charge entity) {

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	public void deleteAll(Iterable<? extends Charge> entities) {

	}

	public void deleteAll() {

	}

}
