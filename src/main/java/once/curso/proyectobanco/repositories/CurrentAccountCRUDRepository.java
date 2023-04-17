package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;

import once.curso.proyectobanco.entities.CurrentAccount;

public interface CurrentAccountCRUDRepository extends CrudRepository<CurrentAccount, Integer> {
	
}
