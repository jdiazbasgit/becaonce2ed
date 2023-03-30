package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.MaritalStatus;

public class MaritalStatusRepository {


	@Repository
	public interface MaritalStatusRepository extends CrudRepository<MaritalStatus, Integer> {
	}
}
