package once.curso.proyectotienda.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.entities.SoldProduct;

@Repository
public interface SoldProductCRUDRepository extends PagingAndSortingRepository<SoldProduct, Integer> {

	public Optional<SoldProduct> findByExistingProduct(ExistingProduct existingProduct);
	public Optional<SoldProduct> findByProfile(Profile profile);

	@Query("from SoldProduct as s where s.profile.user.user = :user")
	public List<SoldProduct> findAllbyName(String user);
	
}
