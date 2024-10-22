package once.curso.proyectotienda.restcontrollers;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.model.SubCategoryModelAssembler;
import once.curso.proyectotienda.services.SubCategoryService;

@RestController
@Data
@RequestMapping("/once")
public class SubCategoryRestController {

	@Autowired
	private SubCategoryModelAssembler subCategoryModelAssembler;
	@Autowired
	private PagedResourcesAssembler<SubCategory> pagedResourcesAssembler;

	@Autowired
	private SubCategoryService subcategoryService;

	/*
	 * @GetMapping("/subcategory")
	 * 
	 * @CrossOrigin(origins ="*") public Iterable<SubCategory> findAll(){ return
	 * getSubcategoryService().findAll(); }
	 */

	/*
	 * @GetMapping("/subcategories")
	 * 
	 * @CrossOrigin(origins ="*") public CollectionModel<SubCategory>
	 * getSubCategory() { Iterable<SubCategory> subCategory =
	 * getSubcategoryService().findAll(); subCategory.forEach(s->{
	 * s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.
	 * class).findById(s.getCategory().getId())).withRel("subcategory"));
	 * s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.
	 * class).findById(s.getId())).withSelfRel()); }); return
	 * CollectionModel.of(subCategory); }
	 */

	@GetMapping("/subcategories/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<SubCategory> findById(@PathVariable int id) {
		SubCategory subCategory = getSubcategoryService().findById(id).get();
		subCategory.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class).findById(subCategory.getCategory().getId()))
				.withRel("category"));
		subCategory.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController.class).findById(subCategory.getId()))
				.withSelfRel());
		return EntityModel.of(subCategory);
	}

	@GetMapping("/subcategories")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<SubCategory>> findAllPaginado(@RequestParam(required = false) Integer size,
			@RequestParam(required = false) Integer page, @RequestParam(required = false) String sort) {
		Sort orden = null;
		String campo;
		String tipoOrden;
		orden = Sort.by("description");
		if (sort != null) {
			StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
			
			campo = stringTokenizer.nextToken();
			tipoOrden = stringTokenizer.nextToken();

			if (tipoOrden.equals("asc"))
				orden = Sort.by(campo).ascending();
			else
				orden = Sort.by(campo).descending();
		}
		if (size == null)
			size = (int) getSubcategoryService().count();
		if (page == null)
			page = 0;
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<SubCategory> subcategory = getSubcategoryService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(subcategory, getSubCategoryModelAssembler());
	}

	@PostMapping("/subcategories")
	@CrossOrigin(origins = "*")
	public boolean save(@RequestBody SubCategory subCategory) {

		return existById(getSubcategoryService().save(subCategory).getId());
	}

	@DeleteMapping("/subcategories/{id}")
	@CrossOrigin(origins = "*")
	public boolean deleteById(@PathVariable int id) {
		getSubcategoryService().deleteById(id);
		return getSubcategoryService().existsById(id);
	}

	@PostMapping("/subcategories/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getSubcategoryService().existsById(id);
	}

}
