package curso.once.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.once.proyectotienda.entitypes.Profiles;

@Repository
public interface ProfilesRepository extends CrudRepository<Profiles, Integer> {

}
