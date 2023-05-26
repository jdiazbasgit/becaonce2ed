package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.Rol;
@Repository
public interface RolCRUDRepository extends PagingAndSortingRepository<Rol, Integer> {

}
