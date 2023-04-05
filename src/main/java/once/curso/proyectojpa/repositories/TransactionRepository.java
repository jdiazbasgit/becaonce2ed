package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
