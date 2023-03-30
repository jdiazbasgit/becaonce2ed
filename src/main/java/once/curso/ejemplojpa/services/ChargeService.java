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
		
		Iterable<Charge> cargos= getChargeRepository().findAll();
		for (Charge charge : cargos) {
			System.out.println(charge.getDescription());
		}
	}
	
	public String[] dameCargosQueEmpiecenPor(String filtro){
		return getChargeRepository().dameCargosQueEmpiecenPor(filtro);
	}
	public <S extends Charge> S save(S entity) {
		return getChargeRepository().save(entity);
	}

	public <S extends Charge> Iterable<S> saveAll(Iterable<S> entities) {
		return getChargeRepository().saveAll(entities);
	}

	public Optional<Charge> findById(Integer id) {
		return getChargeRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getChargeRepository().existsById(id);
	}

	public Iterable<Charge> findAll() {
		return getChargeRepository().findAll();
	}

	public Iterable<Charge> findAllById(Iterable<Integer> ids) {
		return getChargeRepository().findAllById(ids);
	}

	public long count() {
		return getChargeRepository().count();
	}

	public void deleteById(Integer id) {
		getChargeRepository().deleteById(id);
		
	}

	public void delete(Charge entity) {
		getChargeRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChargeRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Charge> entities) {
		getChargeRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChargeRepository().deleteAll();
	}

	
}






