package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectobanco.entities.AwardsFinesType;

public interface AwardFineTypeCRUDRepositories extends PagingAndSortingRepository<AwardsFinesType, Integer> {

}
