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
import once.curso.proyectobanco.entities.Profile;

import once.curso.proyectobanco.models.ProfileModelAssembler;

import once.curso.proyectobanco.services.ProfileService;

@RestController
@Data
@RequestMapping("/once")
@CrossOrigin(origins = "*")
public class ProfileRestController {

	@Autowired
	private ProfileModelAssembler profileModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<Profile> pagedResourcesAssembler;
	
	@Autowired
	private ProfileService profileService;

	@GetMapping("/profiles/{id}")
	public EntityModel<Profile> findById(@PathVariable Integer id) {
	Profile profile= getProfileService().findById(id).get();
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class)
			  .findById(profile.getIdentificationType().getId())).withRel("identificationType"));
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
			  .findById(profile.getUser().getId())).withRel("user"));
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
			  .findById(profile.getId())).withSelfRel());
	return EntityModel.of(profile);
	}
	
		
	@GetMapping(value = "/profiles")
	public PagedModel<EntityModel<Profile>> findAll(@RequestParam (defaultValue = "0") int size, @RequestParam (defaultValue = "0") int page, @RequestParam (required = false) String sort){
		if (size == 0) {
			size = (int) getProfileService().count();
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
		Page<Profile> profile = getProfileService().findAll(pageable);
		 
		 return getPagedResourcesAssembler().toModel(profile,getProfileModelAssembler());
	}

	
	@PostMapping("/profiles")
	public boolean save(@RequestBody Profile profile) {
		return getProfileService().existsById(getProfileService().save(profile).getId());
	}
	
	@PutMapping("/profiles")
	public List <Profile> saveAll(@RequestBody List<Profile> profiles) {
		return (List<Profile>) getProfileService().saveAll(profiles);
	}

	@DeleteMapping("/profiles/{id}")
	public void deleteById(@PathVariable int id) {
		getProfileService().deleteById(id);
	}	
}