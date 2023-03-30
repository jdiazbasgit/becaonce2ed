package once.curso.ejemplojpa.repositories;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import once.curso.ejemplojpa.entityes.Company;



public interface CompanyRepository extends CrudRepository<Company, Integer>{
	
	@Query(value ="select c.description froom companies c where c.descripcion like",nativeQuery = true)
	public String[] dameCompany(String filtro);

}
