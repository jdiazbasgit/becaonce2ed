package once.curso.proyectotienda.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectotienda.entities.ExistingProduct;

@Repository
public interface ExistingProductCRUDRepository extends PagingAndSortingRepository<ExistingProduct, Integer> {

}
