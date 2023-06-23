package once.curso.proyectobanco.restcontrollers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.models.ConfigurationModelAssember;
import once.curso.proyectobanco.services.ConfigurationService;

@RestController
@Data
@RequestMapping("/once")
public class ConfigurationRestController {
	@Autowired
	private ConfigurationService configurationService;
	
	@Autowired
	private ConfigurationModelAssember configurationModelAssember;
	
	@Autowired
	private  PagedResourcesAssembler<Configuration> pagedResourcesAssemble;
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value =" /configurations/{id}")
	
	public EntityModel< Configuration> findById(@PathVariable Integer id) {
		Configuration configuration= getConfigurationService().findById(id).get();
		configuration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class)
				.findById(configuration.getId())).withSelfRel());
		
		 return  EntityModel.of(configuration);
		 
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/configurations")
	
	public PagedModel<EntityModel<Configuration>> findAll(@RequestParam(defaultValue = "0")int size,@RequestParam(defaultValue = "0")int page,
			@RequestParam(required = false)String sort){
		if(size==0) {
			size=(int) getConfigurationService().count();
		}
			
		Sort orden=Sort.by("id");
		if( sort !=null) {
			orden=Sort.by(sort);
			StringTokenizer stringTokenizer= new StringTokenizer(sort,",");
			
			String campo=stringTokenizer.nextToken();
			String tipoOrden=stringTokenizer.nextToken();
			
			if(tipoOrden.equals("asc"))
				orden=Sort.by(campo).ascending();
			else
				orden=Sort.by(campo).descending();
			
			
		}
		Pageable pageable=PageRequest.of(page, size,orden);
		Page<Configuration> configuration = getConfigurationService().findAll(pageable);
					
		 return getPagedResourcesAssemble().toModel(configuration,getConfigurationModelAssember());
		 	 
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/configurations")
	public Configuration save(@RequestBody Configuration configuration) {
		return getConfigurationService().save(configuration);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value="/configurations/{id}")
	public boolean deleteById(@PathVariable Integer id) {
		getConfigurationService().deleteById(id);
		return getConfigurationService().existsById(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/configurations/{id}")
	public boolean existsById(@PathVariable Integer id) {
		return getConfigurationService().existsById(id);
	}
	

}