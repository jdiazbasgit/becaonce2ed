package once.curso.proyectotienda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectotienda.entity.CardType;

@Repository
public interface CardTypeRepository extends CrudRepository<CardType, Integer>{}

	
