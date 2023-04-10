package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
