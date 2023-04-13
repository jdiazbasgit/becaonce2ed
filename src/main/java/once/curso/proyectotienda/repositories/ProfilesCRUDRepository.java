package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entitypes.Profiles;

@Repository
public interface ProfilesCRUDRepository extends CrudRepository<Profiles, Integer> {

}
