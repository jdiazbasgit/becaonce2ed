package once.curso.proyectobanco.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectobanco.entities.TransactionAwardFine;

public interface TransactionsAwardsFineCRUDRepository extends PagingAndSortingRepository<TransactionAwardFine, Integer> {



}
