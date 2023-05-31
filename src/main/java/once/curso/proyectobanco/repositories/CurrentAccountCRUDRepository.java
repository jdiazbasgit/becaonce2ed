package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectobanco.entities.CurrentAccount;

public interface CurrentAccountCRUDRepository extends PagingAndSortingRepository<CurrentAccount, Integer> {

}
