package once.curso.ejemplojpa.repositories;


import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Charge;

@Repository //es un @Component con caracteristicas de repositorio          //creamos una interface que hereda de otra interface.
public interface ChargeRepository extends CrudRepository<Charge, Integer> {//esto incrementara una interface que se llama crudrepositorieme  pide que le diga 2 cosas
	                                                                       //1.- que le diga sobre que entidad voy a trabajar
	                                                                       //2.- y de que tipo es la clave primaria PK, integer(int).
	                                                                       	
	
	@Query(value="select c.description from charges c where c.description like :filtro",nativeQuery = true)
	@Lazy
	public String[] dameCargosQueEmpiecenPor(String filtro);
	
}
