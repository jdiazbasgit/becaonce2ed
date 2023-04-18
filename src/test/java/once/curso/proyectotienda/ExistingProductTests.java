package once.curso.proyectotienda;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import once.curso.proyectotienda.restcontrollers.ExistingProductRestController;

@SpringBootTest
public class ExistingProductTests {	
	 @Autowired
	    private ExistingProductRestController existingProductRestController;

	    @Test
	    public void testGetAllExistingProduct() throws Exception {
	        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(existingProductRestController).build();
	        mockMvc.perform(get("/products/"))
	            .andExpect(status().isOk())
	            .andExpect(view().name("products"));
	        	//.andExpect(model().attribute("products",  hasSize(2)));
	            /*.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
	            .andExpect(jsonPath("$[0].name", is("Product 1")))
	            .andExpect(jsonPath("$[1].name", is("Product 2")));*/
	    }
}
