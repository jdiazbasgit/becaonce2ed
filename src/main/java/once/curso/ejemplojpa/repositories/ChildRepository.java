package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Child;

public interface ChildRepository extends CrudRepository<Child, Integer> {



}
