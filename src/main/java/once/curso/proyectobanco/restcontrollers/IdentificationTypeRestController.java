package once.curso.proyectobanco.restcontrollers;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
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
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.models.IdentificationTypeModelAssembler;
import once.curso.proyectobanco.services.IdentificationTypeService;

@RestController
@Data
@RequestMapping("/once")
@CrossOrigin(origins = "*")
public class IdentificationTypeRestController {
	
	@Autowired
	private IdentificationTypeModelAssembler identificationTypeModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<IdentificationType> pagedResourcesAssembler;

	@Autowired
	private IdentificationTypeService identificationTypeService;


	@GetMapping(value = "/identificationsTypes/{id}")
	public EntityModel<IdentificationType> findById(@PathVariable Integer id) {
		IdentificationType identificationType=  getIdentificationTypeService().findById(id).get();
		identificationType.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class)
				.findById(identificationType.getId())).withSelfRel());
		 return EntityModel.of(identificationType);
	}
	
	@GetMapping(value = "/identificationTypes")
	public PagedModel<EntityModel<IdentificationType>> findAll(@RequestParam (defaultValue = "0") int size, @RequestParam (defaultValue = "0") int page, @RequestParam (required = false) String sort){
		if (size == 0) {
			size = (int) getIdentificationTypeService().count();
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
		
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<IdentificationType> identificationType = getIdentificationTypeService().findAll(pageable);
		 
		 return getPagedResourcesAssembler().toModel(identificationType,getIdentificationTypeModelAssembler());
	}
	
	@PostMapping("/identificationsTypes")
	public IdentificationType save(@RequestBody IdentificationType identificationType) {
		return getIdentificationTypeService().save(identificationType);
	}
	
	@PutMapping("/identificationsTypes")
	public List <IdentificationType> saveAll(@RequestBody List<IdentificationType> identificationsTypes) {
		return (List<IdentificationType>) getIdentificationTypeService().saveAll(identificationsTypes);
	}

	@DeleteMapping("/identificationsTypes/{id}")
	public void deleteById(@PathVariable int id) {
		getIdentificationTypeService().deleteById(id);
	}	
}