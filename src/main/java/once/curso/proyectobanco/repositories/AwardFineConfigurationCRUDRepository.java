package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectobanco.entities.AwardFineConfiguration;
@Repository
public interface AwardFineConfigurationCRUDRepository extends PagingAndSortingRepository<AwardFineConfiguration, Integer> {

}
