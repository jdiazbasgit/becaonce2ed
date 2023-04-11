package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import once.curso.proyectojpa.entities.ExistingProduct;

@Service
public interface ExistingProductRepository extends CrudRepository<ExistingProduct, Integer> {

}
