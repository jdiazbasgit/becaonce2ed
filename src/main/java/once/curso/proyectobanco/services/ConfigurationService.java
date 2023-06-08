package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.repositories.ConfigurationCRUDRepository;

@Data
@Service
public class ConfigurationService {
	
	@Autowired
	private ConfigurationCRUDRepository configurationCRUDRepository;
	
	public Iterable<Configuration>dameConfiguracion() {
		return getConfigurationCRUDRepository().findAll();
		
	}

	public <S extends Configuration> S save(S entity) {
		return getConfigurationCRUDRepository().save(entity);
	}

	public <S extends Configuration> Iterable<S> saveAll(Iterable<S> entities) {
		return getConfigurationCRUDRepository().saveAll(entities);
	}

	public Optional<Configuration> findById(Integer id) {
		return getConfigurationCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getConfigurationCRUDRepository().existsById(id);
	}

	public Iterable<Configuration> findAll() {
		return getConfigurationCRUDRepository().findAll();
	}
	
	public Page<Configuration> findAll(Pageable pageable) {
		return getConfigurationCRUDRepository().findAll(pageable);
	}
	
	public Iterable<Configuration> findAllById(Iterable<Integer> ids) {
		return getConfigurationCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getConfigurationCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		
		getConfigurationCRUDRepository().deleteById(id);
	}

	public void delete(Configuration entity) {
		getConfigurationCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getConfigurationCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Configuration> entities) {
		getConfigurationCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getConfigurationCRUDRepository().deleteAll();
	}

	
}
