package once.curso.ejemplojpa.restcontrollers;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import lombok.Data;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.model.ChildModelAssembler;
import once.curso.ejemplojpa.services.ChildService;

@RestController
@RequestMapping("/once")
@Data
public class ChildRestController {
	
	@Autowired
	private ChildModelAssembler childModelAssembler;
	
	@Autowired
	private  PagedResourcesAssembler<Child> pagedResourcesAssembler;
	
	@Autowired
	private ChildService childService;

	
	@PostMapping("/children")
	public Child save(@RequestBody Child child) {
		return getChildService().save(child);
	}

//	@GetMapping("/children")
//	public CollectionModel<Child> findAll() {
//		Iterable<Child> children = getChildService().findAll();
//		
//		  children.forEach(c->{ c.add(WebMvcLinkBuilder.
//		  linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class).
//		  getChildrenById(c.getId())).withSelfRel()); });
//		 
//
//		return CollectionModel.of(children);
//	}

	//defaultValue = String.valueOf(getChildService().count()
	//Long.MAX_VALUE + ""
	@GetMapping("/children")
	public PagedModel<EntityModel<Child>> findAllPaginado(@RequestParam (defaultValue = "1000")int size, @RequestParam (defaultValue = "0")int page,
			@RequestParam (required = false)String sort) {
		//Iterable<Child> children = getChildService().findAll();
		
		Sort orden=Sort.by("id");
		if (sort != null) {
			orden=Sort.by(sort);		
			StringTokenizer stringTokenizer= new StringTokenizer(sort,",");
			
			
			String campo=stringTokenizer.nextToken();
			String tipoOrden=stringTokenizer.nextToken();
			
			if(tipoOrden.equals("asc"))
				orden=Sort.by(campo).ascending();
			else
				orden=Sort.by(campo).descending();
		}
		
		
		Pageable pageable=PageRequest.of(page,size,orden);
		Page<Child> child=getChildService().findAll(pageable);
		
		/*
		 * children.forEach(c->{ c.add(WebMvcLinkBuilder.
		 * linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class).
		 * getChildrenById(c.getId())).withSelfRel()); });
		 */

		return getPagedResourcesAssembler().toModel(child,getChildModelAssembler());
	}

	@GetMapping("/children/{id}")
	public EntityModel<Child> getChildrenById(@PathVariable int id) {
		Child child = getChildService().findById(id).get();

		child.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class).getChildrenById(child.getId()))
				.withSelfRel());
		return EntityModel.of(child);
	}

	@DeleteMapping("/children/{id}")
	public void deleteById(@PathVariable int id) {
		getChildService().deleteById(id);
	}

}
