package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends CrudRepository<CurrentAccount, Integer> {

}
