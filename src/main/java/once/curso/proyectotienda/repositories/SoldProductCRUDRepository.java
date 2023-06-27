package once.curso.proyectotienda.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.entities.SoldProduct;

@Repository
public interface SoldProductCRUDRepository extends PagingAndSortingRepository<SoldProduct, Integer> {

	public Optional<SoldProduct> findByExistingProduct(ExistingProduct existingProduct);
	public Optional<SoldProduct> findByProfile(Profile profile);
	
}
