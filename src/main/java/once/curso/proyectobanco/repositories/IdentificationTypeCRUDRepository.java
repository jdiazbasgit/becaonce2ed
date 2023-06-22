package once.curso.proyectobanco.repositories;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.IdentificationType;

@Repository
public interface IdentificationTypeCRUDRepository extends PagingAndSortingRepository<IdentificationType, Integer> {

	

}
