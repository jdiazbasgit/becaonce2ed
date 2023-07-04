package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.repositories.AwardFineConfigurationCRUDRepository;

@Service
@Data
public class AwardFineConfigurationService {

	@Autowired
	private AwardFineConfigurationCRUDRepository awardFineConfigurationCRUDRepository;

	public void damePremiosMultasConfiguraciones() {

		//Iterable<AwardsFinesConfiguration> awardsFinesConfigurations = getAwardFineConfigurationCRUDRepositories()
			//	.findAll();
		//for (AwardsFinesConfiguration awardFineConfiguration : awardsFinesConfigurations) {
			//System.out.println(awardFineConfiguration.getCurrent());
			//System.out.println(awardFineConfiguration.getDescription());
		}

	public <S extends AwardFineConfiguration> S save(S entity) {

		return getAwardFineConfigurationCRUDRepository().save(entity);
	}

	public <S extends AwardFineConfiguration> Iterable<S> saveAll(Iterable<S> entities) {

		return getAwardFineConfigurationCRUDRepository().saveAll(entities);
	}

	public Optional<AwardFineConfiguration> findById(Integer id) {

		return getAwardFineConfigurationCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getAwardFineConfigurationCRUDRepository().existsById(id);
	}

	public Iterable<AwardFineConfiguration> findAll() {

		return getAwardFineConfigurationCRUDRepository().findAll();
	}
	
	public Page<AwardFineConfiguration> findAll(Pageable pageable) {

		return getAwardFineConfigurationCRUDRepository().findAll(pageable);
	}

	public Iterable<AwardFineConfiguration> findAllById(Iterable<Integer> ids) {

		return getAwardFineConfigurationCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getAwardFineConfigurationCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getAwardFineConfigurationCRUDRepository().deleteById(id);

	}

	public void delete(AwardFineConfiguration entity) {
		getAwardFineConfigurationCRUDRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineConfigurationCRUDRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends AwardFineConfiguration> entities) {
		getAwardFineConfigurationCRUDRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getAwardFineConfigurationCRUDRepository().deleteAll();

	}

}
