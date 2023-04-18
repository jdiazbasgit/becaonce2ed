package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.repositories.AwardFineConfigurationCRUDRepositories;

@Service
@Data
public class AwardsFinesConfigurationServices {

	@Autowired
	private AwardFineConfigurationCRUDRepositories awardFineConfigurationCRUDRepositories;

	public void damePremiosMultasConfiguraciones() {

		Iterable<AwardFineConfiguration> awardsFinesConfigurations = getAwardFineConfigurationCRUDRepositories()
				.findAll();
		for (AwardFineConfiguration awardFineConfiguration : awardsFinesConfigurations) {
			//System.out.println(awardFineConfiguration.getCurrent());
			//System.out.println(awardFineConfiguration.getDescription());
		}
	}

	public <S extends AwardFineConfiguration> S save(S entity) {

		return getAwardFineConfigurationCRUDRepositories().save(entity);
	}

	public <S extends AwardFineConfiguration> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineConfigurationCRUDRepositories().saveAll(entities);
	}

	public Optional<AwardFineConfiguration> findById(Integer id) {

		return getAwardFineConfigurationCRUDRepositories().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineConfigurationCRUDRepositories().existsById(id);
	}

	public Iterable<AwardFineConfiguration> findAll() {

		return getAwardFineConfigurationCRUDRepositories().findAll();
	}

	public Iterable<AwardFineConfiguration> findAllById(Iterable<Integer> ids) {

		return getAwardFineConfigurationCRUDRepositories().findAllById(ids);
	}

	public long count() {

		return getAwardFineConfigurationCRUDRepositories().count();
	}

	public void deleteById(Integer id) {
		getAwardFineConfigurationCRUDRepositories().deleteById(id);

	}

	public void delete(AwardFineConfiguration entity) {
		getAwardFineConfigurationCRUDRepositories().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineConfigurationCRUDRepositories().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFineConfiguration> entities) {
		getAwardFineConfigurationCRUDRepositories().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineConfigurationCRUDRepositories().deleteAll();

	}

}
