package once.curso.proyectobanco.restcontrollers;

import java.util.List;
import java.util.StringTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.domain.Sort;
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
import once.curso.proyectobanco.entities.TimingType;
import once.curso.proyectobanco.models.TimingTypeModelAssembler;
import once.curso.proyectobanco.services.TimingTypeService;

@Data
@RestController
@RequestMapping("/once")
public class TimingTypeRestController {

	@Autowired
	private TimingTypeService timingTypeService;
	@Autowired
	private TimingTypeModelAssembler timingTypeModelAssembler;
	@Autowired
	private PagedResourcesAssembler<TimingType> pagedResourcesAssembler;

	@GetMapping(value = "/timingsTypes/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<TimingType> findById(@PathVariable int id) {
		TimingType timingType = getTimingTypeService().findById(id).get();
		timingType.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TimingTypeRestController.class).findById(timingType.getId()))
				.withSelfRel());
		return EntityModel.of(timingType);
	}

	@GetMapping(value="/timingsTypes")
	@CrossOrigin(origins="*")
	public PagedModel<EntityModel<TimingType>>findAll(@RequestParam(defaultValue="0") int size, @RequestParam(defaultValue="0") int page,
			@RequestParam(required= false) String sort){
		if (size==0) {
			size=(int) getTimingTypeService().count();
		}
		Sort orden =Sort.by("id");
		if (sort != null) {
			orden =Sort.by(sort);
			StringTokenizer stringTokenizer= new StringTokenizer(sort, ",");
			String campo = stringTokenizer.nextToken();
			String tipoOrden = stringTokenizer.nextToken();
			if (tipoOrden.contentEquals("asc")) {
				orden= Sort.by(campo).ascending();
			}
			else {
				orden =Sort.by(campo).descending();
			}

}
		Pageable pageable =PageRequest.of(page, size, orden);
		Page<TimingType> timingType=getTimingTypeService().findAll(pageable);
		return getPagedResourcesAssembler().toModel(timingType,getTimingTypeModelAssembler());
	}
	@PostMapping (value="/timingsTypes")
	@CrossOrigin(origins="*")
	public boolean save(@RequestBody TimingType timingType) {
		return getTimingTypeService().existsById(getTimingTypeService().save(timingType).getId());
	}
	@PutMapping(value="/timingsTypes")
	@CrossOrigin(origins = "*")
	public List<TimingType> saveAll(@RequestBody List<TimingType> timingTypes){
		return (List<TimingType>)getTimingTypeService().saveAll(timingTypes);
	}
	@DeleteMapping(value="timingsTypes/{id}")
	@CrossOrigin(origins = "*")
	public void deleteById(@PathVariable Integer id) {
		getTimingTypeService().deleteById(id);
	}
	@PostMapping(value="/timingsTypes/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getTimingTypeService().existsById(id);
	}
}
	
	
	
	
	
	
