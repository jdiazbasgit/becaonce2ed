package once.curso.ejemplojpa.repositories;


import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Charge;


@Repository
public interface ChargeRepository extends CrudRepository<Charge, Integer> {
	
	@Query(value="select c.description from charges c where c.description like :filtro",nativeQuery = true)
	@Lazy
	public String[] dameCargosQueEmpiecenPor(String filtro);

	

	
	
}
