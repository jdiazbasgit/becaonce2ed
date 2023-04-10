package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends CrudRepository<CurrentAccount, Integer> {

}
