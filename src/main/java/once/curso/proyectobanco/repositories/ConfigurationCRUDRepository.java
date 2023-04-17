package once.curso.proyectobanco.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.proyectobanco.entities.Configuration;

public interface ConfigurationCRUDRepository extends CrudRepository<Configuration, Integer> {

}
