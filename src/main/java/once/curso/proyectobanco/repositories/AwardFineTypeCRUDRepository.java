package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectobanco.entities.AwardFineType;
@Repository
public interface AwardFineTypeCRUDRepository extends PagingAndSortingRepository<AwardFineType, Integer> {

}