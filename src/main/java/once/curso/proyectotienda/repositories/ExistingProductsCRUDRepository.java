package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entitypes.ExistingProducts;

@Repository
public interface ExistingProductsCRUDRepository extends CrudRepository<ExistingProducts, Integer> {

}
