package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.TimingType;
import once.curso.proyectobanco.repositories.TimingTypeCRUDRepository;

@Data
@Service
public class TimingTypeService {
	
	@Autowired
	private TimingTypeCRUDRepository timingTypeCRUDRepository;

	
	public <S extends TimingType> S save(S entity) {
				return getTimingTypeCRUDRepository().save(entity);
	}

	
	public <S extends TimingType> Iterable<S> saveAll(Iterable<S> entities) {
		return getTimingTypeCRUDRepository().saveAll(entities);
	}

	public Optional<TimingType> findById(Integer id) {
		return getTimingTypeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getTimingTypeCRUDRepository().existsById(id);
	}

	public Iterable<TimingType> findAll() {
		return getTimingTypeCRUDRepository().findAll();
	}

	public Iterable<TimingType> findAllById(Iterable<Integer> ids) {
		return getTimingTypeCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getTimingTypeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
getTimingTypeCRUDRepository().deleteById(id);		
	}

	public void delete(TimingType entity) {
getTimingTypeCRUDRepository().delete(entity);		
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {

getTimingTypeCRUDRepository().deleteAllById(ids);
		
	}

	public void deleteAll(Iterable<? extends TimingType> entities) {
getTimingTypeCRUDRepository().deleteAll(entities);		
	}

	public void deleteAll() {
getTimingTypeCRUDRepository().deleteAll();		
	}

	public Iterable<TimingType> findAll(Sort sort) {
		return getTimingTypeCRUDRepository().findAll(sort);
	}

	public Page<TimingType> findAll(Pageable pageable) {
		return getTimingTypeCRUDRepository().findAll(pageable);
	}

}
