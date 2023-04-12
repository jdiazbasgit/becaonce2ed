package once.curso.banco.bancoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.banco.bancoentityes.Configuration;
import once.curso.banco.bancorepositories.ConfigurationRepository;

@Data
@Service
public class ConfigurationService {
	
	@Autowired
	private ConfigurationRepository configurationRepository;
	
	public void dameConfiguracion() {
		Iterable<Configuration> configuracion= getConfigurationRepository().findAll();
		for (Configuration configuration : configuracion) {
			System.out.println(configuration.getLiveTime());
			
		}
	}
	public long count() {
		return getConfigurationRepository().count();
	}

	public void delete(Configuration entity) {
getConfigurationRepository().delete(entity);		
	}

	public void deleteAll() {
getConfigurationRepository().deleteAll();		
	}

	public void deleteAll(Iterable<? extends Configuration> entities) {
getConfigurationRepository().deleteAll(entities);		
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getConfigurationRepository().deleteAllById(ids);
	}

	public void deleteById(Integer id) {
		getConfigurationRepository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getConfigurationRepository().existsById(id);
	}

	public Iterable<Configuration> findAll() {
		return null;
	}

	public Iterable<Configuration> findAllById(Iterable<Integer> ids) {
		return getConfigurationRepository().findAllById(ids);
	}

	public Optional<Configuration> findById(Integer id) {
		return getConfigurationRepository().findById(id);
	}

	public <S extends Configuration> S save(S entity) {
		return getConfigurationRepository().save(entity);
	}

	public <S extends Configuration> Iterable<S> saveAll(Iterable<S> entities) {
		return getConfigurationRepository().saveAll(entities);
	}

}
