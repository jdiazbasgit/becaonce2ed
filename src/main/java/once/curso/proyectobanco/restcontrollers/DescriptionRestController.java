package once.curso.proyectobanco.restcontrollers;


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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.models.DescriptionModelAssembler;
import once.curso.proyectobanco.services.DescriptionService;

@RestController
@Data
@RequestMapping("/once")
public class DescriptionRestController {
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private PagedResourcesAssembler<Description> PagedResourcesAssembler;
	
	@Autowired 
	private DescriptionModelAssembler descriptionModelAssembler;
	
	@GetMapping(value =" /descriptions/{id}")
	public EntityModel<Description> findById(@PathVariable int id) {
		Description description= getDescriptionService().findById(id).get();
		description.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
				.findById(description.getId())).withSelfRel());
		 return EntityModel.of(description);
	}
	
	@PostMapping(value = "/descriptions")
	public Description save(@RequestBody Description description) {
		return getDescriptionService().save(description);
	}
	
	
	@GetMapping(value = "/descriptions")
	public CollectionModel<Description> findAll() {
		Iterable<Description> descriptions= getDescriptionService().findAll();
		descriptions.forEach(d->{
			  d.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
					  .findById(d.getId())).withRel("description"));
		});
		 return CollectionModel.of(descriptions);
		 }
	
	@GetMapping(value = "/descriptionsPaginado")
	public PagedModel<EntityModel<Description>> findAllPaginado(@RequestParam int size, @RequestParam int page, @RequestParam String sort){
		StringTokenizer stringTokenizer =new StringTokenizer(sort,",");
		Sort orden = Sort.by("a");
		
		String campo=stringTokenizer.nextToken();
		String tipoOrden=stringTokenizer.nextToken();
		
		if(tipoOrden.contentEquals("asc"))
			orden=Sort.by(campo).ascending();
		else
		
			orden=Sort.by(campo).descending();
		
		Pageable pageable = PageRequest.of(page, size,orden);
		Page<Description> description=getDescriptionService().findAll(pageable); 
		
		return getPagedResourcesAssembler().toModel(description,getDescriptionModelAssembler());
	}
	
	@DeleteMapping(value="/description/{id}")
	public void deleteById(@PathVariable Integer id) {
		getDescriptionService().deleteById(id);
	}
	
}
