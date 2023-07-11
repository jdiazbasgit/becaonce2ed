package once.curso.proyectotienda.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import once.curso.proyectotienda.entities.ExistingProduct;

@Repository
public interface ExistingProductCRUDRepository extends PagingAndSortingRepository<ExistingProduct, Integer> {

	//@Query("from ExistingProduct as e where e.subcategory.category.id=:categoryId")
	@Query("SELECT e FROM ExistingProduct e JOIN e.subcategory s JOIN s.category c WHERE c.id = :categoryId")
	public List<ExistingProduct> getExistingProductByCategory(int categoryId);

	@Query("from ExistingProduct as e where e.subcategory.category.id = :categoryId AND e.subcategory.id=:subcategoryId")
	public List<ExistingProduct> getExistingProductByCategoryAndSubCategory( int categoryId, int subcategoryId);

	
}
