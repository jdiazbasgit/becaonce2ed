package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;

import once.curso.proyectobanco.entities.Transaction;

public interface TransactionCRUDRepository extends CrudRepository<Transaction, Integer> {

}
