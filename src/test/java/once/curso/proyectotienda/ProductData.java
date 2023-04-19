package once.curso.proyectotienda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductData {
	private String description;
	private Double price;
	private String image;
	private int stock;
	private int subcategories;
	
	public ProductData(String description2, String string, String image2, int stock2, int subcategories2) {
	}
	
}
