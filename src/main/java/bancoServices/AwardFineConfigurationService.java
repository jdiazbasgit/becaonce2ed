package bancoServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bancoEntityes.AwardFineConfiguration;
import bancoRepositories.AwardFineConfigurationRepository;
import lombok.Data;

@Service
@Data
public class AwardFineConfigurationService {

	@Autowired
	private AwardFineConfigurationRepository awardFineConfigurationRepository;

	public void dameConfiguracionMulta() {
		Iterable<AwardFineConfiguration> configuracionMulta = getAwardFineConfigurationRepository().findAll();
		for (AwardFineConfiguration awardFineConfiguration : configuracionMulta) {
			System.out.println(awardFineConfiguration.getCurrent());
			System.out.println(awardFineConfiguration.getDescription());
		}

	}

	public long count() {
		return getAwardFineConfigurationRepository().count();
	}

	public void delete(AwardFineConfiguration entity) {
		getAwardFineConfigurationRepository().delete(entity);
	}

	public void deleteAll() {
		getAwardFineConfigurationRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends AwardFineConfiguration> entities) {
		getAwardFineConfigurationRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineConfigurationRepository().deleteAllById(ids);;
	}

	public void deleteById(Integer id) {
		getAwardFineConfigurationRepository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getAwardFineConfigurationRepository().existsById(id);
	}

	public Iterable<AwardFineConfiguration> findAll() {
		return getAwardFineConfigurationRepository().findAll();
	}

	public Iterable<AwardFineConfiguration> findAllById(Iterable<Integer> ids) {
		return getAwardFineConfigurationRepository().findAllById(ids);
	}

	public Optional<AwardFineConfiguration> findById(Integer id) {
		return getAwardFineConfigurationRepository().findById(id);
	}

	public <S extends AwardFineConfiguration> S save(S entity) {
		return getAwardFineConfigurationRepository().save(entity);
	}

	public <S extends AwardFineConfiguration> Iterable<S> saveAll(Iterable<S> entities) {
		return getAwardFineConfigurationRepository().saveAll(entities);
	}
}
