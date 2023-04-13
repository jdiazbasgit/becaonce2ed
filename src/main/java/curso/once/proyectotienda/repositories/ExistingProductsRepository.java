package curso.once.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import curso.once.proyectotienda.entitypes.ExistingProducts;

@Repository
public interface ExistingProductsRepository extends CrudRepository<ExistingProducts, Integer> {

}
