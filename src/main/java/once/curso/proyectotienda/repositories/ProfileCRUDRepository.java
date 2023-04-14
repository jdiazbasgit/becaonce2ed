package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entitypes.Profile;

@Repository
public interface ProfileCRUDRepository extends CrudRepository<Profile, Integer> {

}
