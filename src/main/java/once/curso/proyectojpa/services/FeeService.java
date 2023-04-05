package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.Fee;
import once.curso.proyectojpa.repositories.FeeRepository;

@Service
@Data
public class FeeService {

	@Autowired
	private FeeRepository FeeRepository;

	public void dameTarifaActual() {

		Iterable<Fee> current = getFeeRepository().findAll();
		for (Fee fee : current) {
			System.out.println(fee.getCurrent());

		}

	}

	public <S extends Fee> S save(S entity) {

		return getFeeRepository().save(entity);
	}

	public <S extends Fee> Iterable<S> saveAll(Iterable<S> entities) {

		return getFeeRepository().saveAll(entities);
	}

	public Optional<Fee> findById(Integer id) {

		return getFeeRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getFeeRepository().existsById(id);
	}

	public Iterable<Fee> findAll() {

		return getFeeRepository().findAll();
	}

	public Iterable<Fee> findAllById(Iterable<Integer> ids) {

		return getFeeRepository().findAllById(ids);
	}

	public long count() {

		return getFeeRepository().count();
	}

	public void deleteById(Integer id) {
		getFeeRepository().deleteById(id);

	}

	public void delete(Fee entity) {
		getFeeRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getFeeRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends Fee> entities) {
		getFeeRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getFeeRepository().deleteAll();

	}
}
