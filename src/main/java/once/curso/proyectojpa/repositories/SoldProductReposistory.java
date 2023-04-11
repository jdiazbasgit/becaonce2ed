package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.SoldProduct;

@Repository
public interface SoldProductReposistory extends CrudRepository<SoldProduct, Integer> {

}
