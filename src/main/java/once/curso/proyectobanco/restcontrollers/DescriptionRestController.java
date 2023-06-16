package once.curso.proyectobanco.restcontrollers;


import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.models.DescriptionModelAssembler;
import once.curso.proyectobanco.services.DescriptionService;

@RestController
@Data
@RequestMapping("/once")
@CrossOrigin(origins = "*")
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
	public boolean save(@RequestBody Description description) {
		return getDescriptionService().existsById(getDescriptionService().save(description).getId());
	}
	
	/*@GetMapping(value = "/descriptions")
>>>>>>> feature/develop-banco-di
	public CollectionModel<Description> findAll() {
		Iterable<Description> descriptions= getDescriptionService().findAll();
		descriptions.forEach(d->{
			  d.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
					  .findById(d.getId())).withRel("description"));
		});
		 return CollectionModel.of(descriptions);
		 }*/
	
	@GetMapping(value = "/descriptions")
	public PagedModel<EntityModel<Description>> findAll(@RequestParam (defaultValue="0")int size, @RequestParam (defaultValue="0")int page, @RequestParam (required=false)String sort){
//		StringTokenizer stringTokenizer =new StringTokenizer(sort,",");
//		Sort orden = Sort.by("a");
//		
//		String campo=stringTokenizer.nextToken();
//		String tipoOrden=stringTokenizer.nextToken();
//		
//		if(tipoOrden.contentEquals("asc"))
//			orden=Sort.by(campo).ascending();
//		else
//		
//			orden=Sort.by(campo).descending();
		
		if (size == 0) {
			size = (int) getDescriptionService().count();
		}
		Sort orden = Sort.by("id");	
		if (sort != null) {
			orden = Sort.by(sort);
			StringTokenizer stringTokenizer = new StringTokenizer(sort,",");
			String campo = stringTokenizer.nextToken();
			String tipoOrden = stringTokenizer.nextToken();
			if (tipoOrden.contentEquals("asc")) {
				orden = Sort.by(campo).ascending();
			}
			else {
				orden = Sort.by(campo).descending();
			}
		}
		
		Pageable pageable = PageRequest.of(page, size,orden);
		Page<Description> description=getDescriptionService().findAll(pageable); 
		
		return getPagedResourcesAssembler().toModel(description,getDescriptionModelAssembler());
	}
	
	@DeleteMapping(value="/description/{id}")
	public boolean deleteById(@PathVariable Integer id) {
		getDescriptionService().deleteById(id);
		return getDescriptionService().existsById(id);
	}
	
	
	@PostMapping(value="/description/{id}")
	public boolean existsById(@PathVariable Integer id) {
		return getDescriptionService().existsById(id);
	}
	
	@PutMapping("/descriptions")
	public List <Description> saveAll(@RequestBody List<Description> descriptions) {
		return (List<Description>) getDescriptionService().saveAll(descriptions);
	}
	
	@PostMapping("/descriptions/{id}")
	public boolean existsById(@PathVariable int id) {
		return getDescriptionService().existsById(id);
	}
}
