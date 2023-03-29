package once.curso.ejemplojpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.MaritalEstatus;

public interface MaritalStatus extends CrudRepository<MaritalEstatus, Integer>{
	
	@Query(value = "Selec e.estados from marital_stauses e where e.estados like  : filtro",nativeQuery = true)
	public String[] dameEstados(String filtro);
	

}
