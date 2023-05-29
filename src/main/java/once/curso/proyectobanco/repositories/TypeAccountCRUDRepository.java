package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;

import once.curso.proyectobanco.entities.TypeAccount;

public interface TypeAccountCRUDRepository extends CrudRepository<TypeAccount, Integer> {
//	@Query("from TypeAccount as ta where ta.description= :dato")
	public TypeAccount findByDescriptionEquals(String dato);
}
