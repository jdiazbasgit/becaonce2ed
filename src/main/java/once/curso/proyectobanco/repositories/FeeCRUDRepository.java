package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.Fee;

@Repository
public interface FeeCRUDRepository extends PagingAndSortingRepository<Fee, Integer> {

}
