package once.curso.proyectotienda.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import once.curso.proyectotienda.entities.ExistingProduct;

@Repository
public interface ExistingProductCRUDRepository extends PagingAndSortingRepository<ExistingProduct, Integer> {

	@Query("from ExistingProduct as e where e.subcategory.category.id=:categoryId")
	public List<ExistingProduct> getExistingProductByCategory(int categoryId);

	@Query(" from ExistingProduct e where e.subcategory.category.id = :categoryId AND e.subcategory.id = :subcategoryId")
	public List<ExistingProduct> getExistingProductByCategoryAndSubCategory( int categoryId, int subcategoryId);

	
	default double countExistingProductByCategory(int category) {
		
		List<ExistingProduct> products = (List<ExistingProduct>) findAll();
		
		products.stream().filter(e->e.getSubcategory().getCategory().getId()==category).mapToDouble(e->e.getPrice()).forEach(p->System.out.println(p));
		
		return products.stream().filter(e->e.getSubcategory().getCategory().getId()==category).mapToDouble(e->e.getPrice()).sum();
	}
	
	default List<ExistingProduct> a(List<ExistingProduct> productos, int category){
		List<ExistingProduct> salida= new ArrayList<ExistingProduct>();
		for (ExistingProduct existingProduct : salida) {
			if(existingProduct.getSubcategory().getCategory().getId()==category)
				salida.add(existingProduct);
		}
		
		return salida;
		
	}
}










