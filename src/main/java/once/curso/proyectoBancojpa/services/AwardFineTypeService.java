package once.curso.proyectoBancojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectoBancojpa.entities.AwardFineType;
import once.curso.proyectoBancojpa.repositories.AwardFineTypeRepository;

@Service
@Data
public class AwardFineTypeService {
	
	@Autowired
	private AwardFineTypeRepository awardFineTypeRepository;
	
	public void dameAwardFineType() {
		
		Iterable<AwardFineType> awardsFinesTypes = getAwardFineTypeRepository().findAll();
		for (AwardFineType awardFineType : awardsFinesTypes) {
			System.out.println(awardFineType.getDescription());
		}
	}
	
	public <S extends AwardFineType> S save(S entity) {
		
		return getAwardFineTypeRepository().save(entity);
	}

	
	public <S extends AwardFineType> Iterable<S> saveAll(Iterable<S> entities) {
		
		return getAwardFineTypeRepository().saveAll(entities);
	}

	
	public Optional<AwardFineType> findById(Integer id) {
		
		return getAwardFineTypeRepository().findById(id);
	}

	
	public boolean existsById(Integer id) {
		
		return getAwardFineTypeRepository().existsById(id);
	}

	
	public Iterable<AwardFineType> findAll() {
		
		return getAwardFineTypeRepository().findAll();
	}

	
	public Iterable<AwardFineType> findAllById(Iterable<Integer> ids) {
		
		return getAwardFineTypeRepository().findAllById(ids);
	}

	
	public long count() {
		
		return getAwardFineTypeRepository().count();
	}

	
	public void deleteById(Integer id) {
	getAwardFineTypeRepository().deleteById(id);	
		
	}

	
	public void delete(AwardFineType entity) {
	getAwardFineTypeRepository().delete(entity);	
		
	}

	
	public void deleteAllById(Iterable<? extends Integer> ids) {
	getAwardFineTypeRepository().deleteAllById(ids);	
		
	}

	
	public void deleteAll(Iterable<? extends AwardFineType> entities) {
	getAwardFineTypeRepository().deleteAll(entities);	
		
	}

	
	public void deleteAll() {
	getAwardFineTypeRepository().deleteAll();	
		
	}
}
