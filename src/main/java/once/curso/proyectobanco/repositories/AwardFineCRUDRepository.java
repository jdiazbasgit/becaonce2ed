package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectobanco.entities.AwardFine;
@Repository
public interface AwardFineCRUDRepository extends PagingAndSortingRepository<AwardFine, Integer> {

}
