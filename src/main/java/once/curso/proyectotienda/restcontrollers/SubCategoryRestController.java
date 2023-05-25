package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.services.SubcategoryService;

@RestController
@Data
@RequestMapping({"/api/v1/"})
public class SubCategoryRestController {

	@Autowired
	private SubcategoryService subcategoryService;
	
	@PostMapping("/subcategory/create")
	public SubCategory save(@RequestBody SubCategory subCategory) {
		return getSubcategoryService().save(subCategory);
	}
	
	@GetMapping("/subcategory")
	public Iterable<SubCategory> findAll(){
		return getSubcategoryService().findAll();
	}
	
	@GetMapping("/subcategoryHateoas")
	public CollectionModel<SubCategory> getSubCategory() {
		Iterable<SubCategory> subCategory = getSubcategoryService().findAll();
		subCategory.forEach(s->{
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(s.getCategory().getId())).withRel("subcategory"));
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(s.getId())).withSelfRel());
		 });
		 return CollectionModel.of(subCategory);
	}	
	
	@GetMapping("/subcategory/{id}")
	public EntityModel<SubCategory> findById(@PathVariable int id) {
		SubCategory subCategory = getSubcategoryService().findById(id).get();
		subCategory.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(subCategory.getCategory().getId())).withRel("subcategory"));
		subCategory.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(subCategory.getId())).withSelfRel());
		 return EntityModel.of(subCategory);
	}
	
	@DeleteMapping("/subcategory/{id}")
	public void deleteById(@PathVariable int id) {
		getSubcategoryService().deleteById(id);
	}
}
