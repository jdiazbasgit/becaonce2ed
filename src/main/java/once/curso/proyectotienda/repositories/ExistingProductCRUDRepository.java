package once.curso.proyectotienda.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectotienda.entities.ExistingProduct;

@Repository
public interface ExistingProductCRUDRepository extends PagingAndSortingRepository<ExistingProduct, Integer> {

	
	@Query("from ExistingProduct as e where e.subcategory.category.id=:categoryId")
	public List<ExistingProduct> getExistingProductByCategory(int categoryId);
	
	
	@Query("from ExstingProduct as s where s.category.subcategory.id=:subCategoryId")
	public List<ExistingProduct> getExistingProductsBySubcategory(int subcategoryId);
}
