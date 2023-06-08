package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.Profile;

@Repository
public interface ProfileCRUDRepository extends PagingAndSortingRepository<Profile, Integer> {

}
