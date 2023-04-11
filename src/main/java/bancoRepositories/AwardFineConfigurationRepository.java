package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.AwardFineConfiguration;

@Repository
public interface AwardFineConfigurationRepository extends CrudRepository<AwardFineConfiguration, Integer> {

	

}
