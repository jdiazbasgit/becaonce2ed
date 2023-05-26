package once.curso.proyectobanco.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectobanco.entities.Configuration;

public interface ConfigurationCRUDRepository extends PagingAndSortingRepository<Configuration, Integer> {

}
