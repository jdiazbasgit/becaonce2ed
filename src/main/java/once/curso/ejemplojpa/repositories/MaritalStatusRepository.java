package once.curso.ejemplojpa.repositories;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.MaritalStatus;

@Repository
public interface MaritalStatusRepository extends CrudRepository<MaritalStatus, Integer> {

}
