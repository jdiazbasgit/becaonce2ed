package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectobanco.entities.Profile;

@Repository
public interface ProfileCRUDRepository extends CrudRepository<Profile, Integer> {

}
