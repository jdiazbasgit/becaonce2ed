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
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.models.AwardFineTypeModelAssembler;
import once.curso.proyectobanco.services.AwardFineTypeService;

@RestController
@RequestMapping("/once")
@Data
@CrossOrigin(origins = "*")
public class AwardFineTypeRestController {
	
	@Autowired
	private AwardFineTypeModelAssembler awardsFinesTypeModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<AwardFineType> PagedResourcesAssembler;

	@Autowired
	private AwardFineTypeService awardFineTypeServices;

	@GetMapping(value = "/awardsFinesTypes/{id}")
	@CrossOrigin(origins = "*")
	
	public EntityModel<AwardFineType> findById(@PathVariable int id) {
		AwardFineType awardsFinesType = getAwardFineTypeServices().findById(id).get();

			awardsFinesType
					.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
							.findById(awardsFinesType.getId())).withSelfRel());
		
		return EntityModel.of(awardsFinesType);
	}

	@GetMapping(value = "/awardsFinesTypes")
	@CrossOrigin(origins = "*")
	
	public PagedModel<EntityModel<AwardFineType>> findAll(@RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "0")int page,
			@RequestParam(required = false)String sort){
		if(size==0) {
			size=(int) getAwardFineTypeServices().count();
		}
		
		Sort orden=Sort.by("id");
		if(sort !=null) {
			orden=Sort.by(sort);
			StringTokenizer stringTokenizer = new StringTokenizer(sort,",");
			
			String campo=stringTokenizer.nextToken();
			String tipoOrden=stringTokenizer.nextToken();
			
			if(tipoOrden.equals("asc"))
				orden=Sort.by(campo).ascending();
			else 
				orden=Sort.by(campo).descending();
			
		}
		Pageable pageable=PageRequest.of(page, size, orden);
		Page<AwardFineType> awardsFinesType = getAwardFineTypeServices().findAll(pageable);
		
		return getPagedResourcesAssembler().toModel(awardsFinesType, getAwardsFinesTypeModelAssembler());
	}

	@PostMapping(value = "/awardsFinesTypes")
	@CrossOrigin(origins = "*")
	
	public boolean save(@RequestBody AwardFineType awardFineType) {
		return getAwardFineTypeServices().existsById(getAwardFineTypeServices().save(awardFineType).getId());	
		}

	@PutMapping(value = "/awardsFinesTypes")
	@CrossOrigin(origins = "*")
	
	public List<AwardFineType> saveAll(@RequestBody List<AwardFineType> awardFineTypes) {
		return (List<AwardFineType>) getAwardFineTypeServices().saveAll(awardFineTypes);
	}

	@DeleteMapping(value = "/awardsFinesTypes/{id}")
	@CrossOrigin(origins = "*")

	public boolean deleteById(@PathVariable int id) {
		getAwardFineTypeServices().deleteById(id);
		return getAwardFineTypeServices().existsById(id);
	}
	
	@PostMapping("/awardsFinesTypes/{id}")
	public boolean existsById(@PathVariable int id) {
		return getAwardFineTypeServices().existsById(id);
	}
}
