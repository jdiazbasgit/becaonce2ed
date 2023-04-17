package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.SoldProduct;

@Repository
public interface SoldProductCRUDRepository extends CrudRepository<SoldProduct, Integer>{}
