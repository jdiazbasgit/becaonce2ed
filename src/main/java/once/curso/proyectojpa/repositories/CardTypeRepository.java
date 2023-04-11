package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.CardType;

@Repository
public interface CardTypeRepository extends CrudRepository<CardType, Integer> {

}
