package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.Transaction;
@Repository
public interface TransactionCRUDRepository extends PagingAndSortingRepository<Transaction, Integer> {

}
