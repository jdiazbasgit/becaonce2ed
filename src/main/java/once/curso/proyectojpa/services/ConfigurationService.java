package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.Configuration;
import once.curso.proyectojpa.repositories.ConfigurationRepository;

@Data
@Service
public class ConfigurationService {

	@Autowired
	private ConfigurationRepository configurationRepository;

	public void dameConfiguraciones() {

		Iterable<Configuration> dameConfiguraciones = getConfigurationRepository().findAll();
		for (Configuration configuration : dameConfiguraciones) {
			System.out.println(configuration.getStockAlarm());

		}
	}

	public <S extends Configuration> S save(S entity) {
		return getConfigurationRepository().save(entity);
	}

	public <S extends Configuration> Iterable<S> saveAll(Iterable<S> entities) {
		return getConfigurationRepository().saveAll(entities);
	}

	public Optional<Configuration> findById(Integer id) {
		return getConfigurationRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getConfigurationRepository().existsById(id);
	}

	public Iterable<Configuration> findAll() {
		return getConfigurationRepository().findAll();
	}

	public Iterable<Configuration> findAllById(Iterable<Integer> ids) {
		return getConfigurationRepository().findAllById(ids);
	}

	public long count() {
		return getConfigurationRepository().count();
	}

	public void deleteById(Integer id) {
		getConfigurationRepository().deleteById(id);
	}

	public void delete(Configuration entity) {
		getConfigurationRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getConfigurationRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Configuration> entities) {
		getConfigurationRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getConfigurationRepository().deleteAll();
	}
}
