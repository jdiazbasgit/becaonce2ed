package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Profile;

@Repository
public interface ProfileCRUDRepository extends PagingAndSortingRepository<Profile, Integer> {

}
