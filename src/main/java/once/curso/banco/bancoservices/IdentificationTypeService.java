package once.curso.banco.bancoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.banco.bancoentityes.IdentificationType;
import once.curso.banco.bancorepositories.IdentificationTypeRespository;

@Data
@Service
public class IdentificationTypeService {
	
	@Autowired
	private IdentificationTypeRespository identificationTypeRespository;
	
	public void dameIdentificacion() {
		Iterable<IdentificationType> identificacion= getIdentificationTypeRespository().findAll();
		for (IdentificationType identificationType : identificacion) {
			System.out.println(identificationType.getDescription());
			
		}
	}
	public long count() {
		return getIdentificationTypeRespository().count();
	}

	public void delete(IdentificationType entity) {
		getIdentificationTypeRespository().delete(entity);
	}

	public void deleteAll() {
		getIdentificationTypeRespository().deleteAll();
	}

	public void deleteAll(Iterable<? extends IdentificationType> entities) {
		getIdentificationTypeRespository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getIdentificationTypeRespository().deleteAllById(ids);
	}

	public void deleteById(Integer id) {
		getIdentificationTypeRespository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getIdentificationTypeRespository().existsById(id);
	}

	public Iterable<IdentificationType> findAll() {
		return getIdentificationTypeRespository().findAll();
	}

	public Iterable<IdentificationType> findAllById(Iterable<Integer> ids) {
		return getIdentificationTypeRespository().findAllById(ids);
	}

	public Optional<IdentificationType> findById(Integer id) {
		return getIdentificationTypeRespository().findById(id);
	}

	public <S extends IdentificationType> S save(S entity) {
		return getIdentificationTypeRespository().save(entity);
	}

	public <S extends IdentificationType> Iterable<S> saveAll(Iterable<S> entities) {
		return getIdentificationTypeRespository().saveAll(entities);
	}

}
