package once.curso.proyectojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
