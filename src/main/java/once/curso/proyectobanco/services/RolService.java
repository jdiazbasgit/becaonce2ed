package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.repositories.RolRepository;

@Data
@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;



public <S extends Rol> S save(S entity) {
	return getRolRepository().save(entity);
}

public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
	return getRolRepository().saveAll(entities);
}

public Optional<Rol> findById(Integer id) {
	return getRolRepository().findById(id);
}

public boolean existsById(Integer id) {
	return getRolRepository().existsById(id);
}

public Iterable<Rol> findAll() {
	return getRolRepository().findAll();
}

public Iterable<Rol> findAllById(Iterable<Integer> ids) {
	return getRolRepository().findAllById(ids);
}

public long count() {
	return getRolRepository().count();
}

public void deleteById(Integer id) {
	getRolRepository().deleteById(id);
}

public void delete(Rol entity) {
	getRolRepository().delete(entity);
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	getRolRepository().deleteAllById(ids);
}

public void deleteAll(Iterable<? extends Rol> entities) {
	getRolRepository().deleteAll(entities);
}

public void deleteAll() {
	getRolRepository().deleteAll();
}
}

