package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.services.CategoryService;

@RestController
@RequestMapping("/once")
@Data
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public CollectionModel<Category> findAll(){
		Iterable<Category> categories= getCategoryService().findAll();
	categories.forEach(c->{
		c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class).findById(c.getId())).withSelfRel());
	});
	return CollectionModel.of(categories);	
	}

   @GetMapping("/categories/{id}")
   public EntityModel<Category> findById(@PathVariable int id){
	   Category category=getCategoryService().findById(id).get();
	   category.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class).findById(category.getId())).withSelfRel());
	   return EntityModel.of(category);
   }
   
	



}
