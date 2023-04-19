package once.curso.proyectotienda;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExistingProductTests {	
	
	public String AddExistingProduct() {
		List<ProductData> listProductData = new ArrayList<ProductData>();
		listProductData.add(new ProductData("bragas para niñas, (Paquete de 5)","15.00", "", 5, 1));
	    //getExistingProductService. listProductData;
	}
	
}