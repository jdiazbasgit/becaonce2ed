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
import once.curso.proyectobanco.entities.AwardsFinesConfiguration;
import once.curso.proyectobanco.models.AwardsFinesConfigurationModelAssembler;
import once.curso.proyectobanco.services.AwardsFinesConfigurationServices;

@RestController
@RequestMapping
@Data
public class AwardsFinesConfigurationRestControllers {
	
	@Autowired
	private AwardsFinesConfigurationModelAssembler awardsFinesConfigurationModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<AwardsFinesConfiguration> PagedResourcesAssembler;

	@Autowired
	private AwardsFinesConfigurationServices awardsFinesConfigurationServices;

	@GetMapping(value = "/awardsFinesConfiguration/{id}")
	public EntityModel<AwardsFinesConfiguration> findById(@PathVariable int id) {
		AwardsFinesConfiguration awardsFinesConfiguration = getAwardsFinesConfigurationServices().findById(id).get();

		awardsFinesConfiguration
				.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
						.findById(awardsFinesConfiguration.getId())).withSelfRel());

		return EntityModel.of(awardsFinesConfiguration);
	}

	@GetMapping(value = "/AwardsFinesConfiguration")
	
	public PagedModel<EntityModel<AwardsFinesConfiguration>> findAll(@RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "0")int page,
			@RequestParam(required = false)String sort){
		if(size==0) {
			size=(int) getAwardsFinesConfigurationServices().count();
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
		Page<AwardsFinesConfiguration> awardsFinesConfiguration = getAwardsFinesConfigurationServices().findAll(pageable);
		
		return getPagedResourcesAssembler().toModel(awardsFinesConfiguration, getAwardsFinesConfigurationModelAssembler());
	}

	@PostMapping(value = "/AwardsFinesConfiguration")
	public AwardsFinesConfiguration save(@RequestBody AwardsFinesConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration);
	}

	@PutMapping(value = "/AwardsFinesConfiguration")
	public List<AwardsFinesConfiguration> saveAll(
			@RequestBody List<AwardsFinesConfiguration> AwardsFinesConfigurations) {
		return (List<AwardsFinesConfiguration>) getAwardsFinesConfigurationServices().findAll();
	}

	@DeleteMapping(value = "/AwardsFinesConfiguration/{id}")
	public AwardsFinesConfiguration deleteById(@RequestBody AwardsFinesConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration);
	}
}
