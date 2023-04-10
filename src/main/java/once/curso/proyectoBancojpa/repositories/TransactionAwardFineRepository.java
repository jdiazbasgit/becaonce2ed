package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.TransactionAwardFine;

@Repository
public interface TransactionAwardFineRepository extends CrudRepository<TransactionAwardFine, Integer> {

}
