package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFinesConfiguration;
import once.curso.proyectobanco.repositories.AwardFineConfigurationCRUDRepositories;

@Service
@Data
public class AwardsFinesConfigurationServices {

	@Autowired
	private AwardFineConfigurationCRUDRepositories awardFineConfigurationCRUDRepositories;

	public void damePremiosMultasConfiguraciones() {

		Iterable<AwardsFinesConfiguration> awardsFinesConfigurations = getAwardFineConfigurationCRUDRepositories()
				.findAll();
		for (AwardsFinesConfiguration awardFineConfiguration : awardsFinesConfigurations) {
			//System.out.println(awardFineConfiguration.getCurrent());
			//System.out.println(awardFineConfiguration.getDescription());
		}
	}

	public <S extends AwardsFinesConfiguration> S save(S entity) {

		return getAwardFineConfigurationCRUDRepositories().save(entity);
	}

	public <S extends AwardsFinesConfiguration> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineConfigurationCRUDRepositories().saveAll(entities);
	}

	public Optional<AwardsFinesConfiguration> findById(Integer id) {

		return getAwardFineConfigurationCRUDRepositories().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineConfigurationCRUDRepositories().existsById(id);
	}

	public Iterable<AwardsFinesConfiguration> findAll() {

		return getAwardFineConfigurationCRUDRepositories().findAll();
	}

	public Iterable<AwardsFinesConfiguration> findAllById(Iterable<Integer> ids) {

		return getAwardFineConfigurationCRUDRepositories().findAllById(ids);
	}

	public long count() {

		return getAwardFineConfigurationCRUDRepositories().count();
	}

	public void deleteById(Integer id) {
		getAwardFineConfigurationCRUDRepositories().deleteById(id);

	}

	public void delete(AwardsFinesConfiguration entity) {
		getAwardFineConfigurationCRUDRepositories().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineConfigurationCRUDRepositories().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardsFinesConfiguration> entities) {
		getAwardFineConfigurationCRUDRepositories().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineConfigurationCRUDRepositories().deleteAll();

	}

}
