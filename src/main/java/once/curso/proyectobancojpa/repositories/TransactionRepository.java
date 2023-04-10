package once.curso.proyectobancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobancojpa.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
