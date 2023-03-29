package once.curso.ejemplojpa.repositories;


import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entities.Charge;

@Repository
public interface ChargeCRUDRepository extends CrudRepository<Charge, Integer> {
	
	@Query(value="select c.description from charges c where c.description like :filtro",nativeQuery = true)
	@Lazy
	public String[] dameCargosQueEmpiecenPor(String filtro);
	
}
