package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.MaritalEstatus;


@Repository
public interface MaritalStatusRepository extends CrudRepository<MaritalEstatus, Integer>{

	
	
	/*@Query(value = "Selec e.description from marital_stauses e where e.description like  : filtro",nativeQuery = true)
	public String[] dameEstados(String filtro);*/
	

}
