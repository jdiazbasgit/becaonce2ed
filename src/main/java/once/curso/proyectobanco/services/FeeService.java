package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.repositories.FeeCRUDRepository;

@Service
@Data
public class FeeService {

	@Autowired
	private FeeCRUDRepository feeCRUDRepository;

	public <S extends Fee> S save(S entity) {
		return getFeeCRUDRepository().save(entity);
	}

	public <S extends Fee> Iterable<S> saveAll(Iterable<S> entities) {
		return getFeeCRUDRepository().saveAll(entities);
	}

	public Optional<Fee> findById(Integer id) {
		return getFeeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getFeeCRUDRepository().existsById(id);
	}

	public Iterable<Fee> findAll() {
		return getFeeCRUDRepository().findAll();
	}
	
	public Page<Fee> findAll(Pageable pageable) {
		return getFeeCRUDRepository().findAll(pageable);
	}

	public Iterable<Fee> findAllById(Iterable<Integer> ids) {
		return getFeeCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getFeeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getFeeCRUDRepository().deleteById(id);
	}

	public void delete(Fee entity) {
		getFeeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getFeeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Fee> entities) {
		getFeeCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getFeeCRUDRepository().deleteAll();
	}
}