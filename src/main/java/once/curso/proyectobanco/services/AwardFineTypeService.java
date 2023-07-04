package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.repositories.AwardFineTypeCRUDRepository;

@Service
@Data
public class AwardFineTypeService {

	@Autowired
	private AwardFineTypeCRUDRepository awardFineTypeCRUDRepository;

	public void dameAwardFineType() {

		//Iterable<AwardsFinesType> awardsFinesTypes = getAwardFineTypeCRUDRepositories().findAll();
		//for (AwardsFinesType awardFineType : awardsFinesTypes) {
			//System.out.println(awardFineType.getDescription());
		}

	public <S extends AwardFineType> S save(S entity) {

		return getAwardFineTypeCRUDRepository().save(entity);
	}

	public <S extends AwardFineType> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineTypeCRUDRepository().saveAll(entities);
	}

	public Optional<AwardFineType> findById(Integer id) {

		return getAwardFineTypeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineTypeCRUDRepository().existsById(id);
	}

	public Iterable<AwardFineType> findAll() {

		return getAwardFineTypeCRUDRepository().findAll();
	}
	
	public Page<AwardFineType> findAll(Pageable pageable) {

		return getAwardFineTypeCRUDRepository().findAll(pageable);
	}
		

	public Iterable<AwardFineType> findAllById(Iterable<Integer> ids) {

		return getAwardFineTypeCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getAwardFineTypeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getAwardFineTypeCRUDRepository().deleteById(id);

	}

	public void delete(AwardFineType entity) {
		getAwardFineTypeCRUDRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineTypeCRUDRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFineType> entities) {
		getAwardFineTypeCRUDRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineTypeCRUDRepository().deleteAll();

	}

}
