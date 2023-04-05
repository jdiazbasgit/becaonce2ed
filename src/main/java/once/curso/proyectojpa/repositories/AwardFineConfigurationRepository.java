package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.AwardFineConfiguration;


@Repository
public interface AwardFineConfigurationRepository extends CrudRepository<AwardFineConfiguration, Integer> {

}
