package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.repositories.TypeAccountCRUDRepository;

@Data
@Service

//fecha
public class TypeAccountService {
	
	@Autowired
	private TypeAccountCRUDRepository typeAccountCRUDRepository;
	
	public void dameTipoDeCuenta() {
		
		Iterable<TypeAccount> tipoCuenta =getTypeAccountCRUDRepository().findAll();
	}
	public <S extends TypeAccount> S save(S entity) {
		return getTypeAccountCRUDRepository().save(entity);
	}

	public <S extends TypeAccount> Iterable<S> saveAll(Iterable<S> entities) {
		return getTypeAccountCRUDRepository().saveAll(entities);
	}

	public Optional<TypeAccount> findById(Integer id) {
		return getTypeAccountCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getTypeAccountCRUDRepository().existsById(id);
	}

	public Iterable<TypeAccount> findAll() {
		return getTypeAccountCRUDRepository().findAll();
	}

	public Iterable<TypeAccount> findAllById(Iterable<Integer> ids) {
		return getTypeAccountCRUDRepository().findAllById(ids);
	}
	public Page<TypeAccount> findAll(Pageable pageable){
		return getTypeAccountCRUDRepository().findAll(pageable);
	}

	public long count() {
		return getTypeAccountCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getTypeAccountCRUDRepository().deleteById(id);
	}

	public void delete(TypeAccount entity) {
		getTypeAccountCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTypeAccountCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends TypeAccount> entities) {
		getTypeAccountCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getTypeAccountCRUDRepository().deleteAll();
	}
	public Optional<TypeAccount> findByDescriptionEquals(String dato) {
		return Optional.of(getTypeAccountCRUDRepository().findByDescriptionEquals(dato));
	}
}
