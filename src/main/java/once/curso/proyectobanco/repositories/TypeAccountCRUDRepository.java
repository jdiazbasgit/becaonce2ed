package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.TypeAccount;
@Repository
public interface TypeAccountCRUDRepository extends PagingAndSortingRepository<TypeAccount, Integer> {
//	@Query("from TypeAccount as ta where ta.description= :dato")
	public TypeAccount findByDescriptionEquals(String dato);
}
