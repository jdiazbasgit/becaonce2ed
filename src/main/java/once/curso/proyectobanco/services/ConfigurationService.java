package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.repositories.ConfigurationCRUDRepository;

@Data
@Service
public class ConfigurationService {
	
	@Autowired
	private ConfigurationCRUDRepository configurationCRUDRepository;
	
	public void dameConfiguracion() {
		Iterable<ConfigurationCRUDRepository> configuration= getConfigurationCRUDRepository().findAll();
		
	}

	public <S extends ConfigurationCRUDRepository> S save(S entity) {
		return getConfigurationCRUDRepository().save(entity);
	}

	public <S extends ConfigurationCRUDRepository> Iterable<S> saveAll(Iterable<S> entities) {
		return getConfigurationCRUDRepository().saveAll(entities);
	}

	public Optional<ConfigurationCRUDRepository> findById(Integer id) {
		return getConfigurationCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getConfigurationCRUDRepository().existsById(id);
	}

	public Iterable<ConfigurationCRUDRepository> findAll() {
		return getConfigurationCRUDRepository().findAll();
	}

	public Iterable<ConfigurationCRUDRepository> findAllById(Iterable<Integer> ids) {
		return getConfigurationCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getConfigurationCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		
		getConfigurationCRUDRepository().deleteById(id);
	}

	public void delete(ConfigurationCRUDRepository entity) {
		getConfigurationCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getConfigurationCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends ConfigurationCRUDRepository> entities) {
		getConfigurationCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getConfigurationCRUDRepository().deleteAll();
	}

	
}
