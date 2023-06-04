package once.curso.proyectotienda.restcontrollers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
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
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.model.ProfileModelAssembler;
import once.curso.proyectotienda.services.ProfileService;

@RestController
@Data
@RequestMapping("/once")
public class ProfileRestController {
	
	@Autowired
	private ProfileModelAssembler profileModelAssembler;

	@Autowired
	private  PagedResourcesAssembler<Profile> pagedResourcesAssembler;

	@Autowired
	private final ProfileService profileService;
	
	/* C CREATE A PROFILE */
	@PostMapping("/profiles/create")
	@CrossOrigin(origins = "*")
	public Profile createProfile(@RequestBody Profile newProfile) {
		return getProfileService().save(newProfile);
	}
	
	/* R READ ALL PROFILE */
	@GetMapping("/profiles")
	@CrossOrigin(origins = "*")
	public CollectionModel<Profile> getProfile() {
		Iterable<Profile> profile = getProfileService().findAll();
		profile.forEach(s->{
			 s.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(s.getUsers().getId())).withRel("user"));
			 s.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(s.getCardstypes().getId())).withRel("cardTypes"));
			 s.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(s.getDocumentstypes().getId())).withRel("docomentTypes"));
			 s.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(s.getId())).withSelfRel());
		 });
		 return CollectionModel.of(profile);
	}	
	
	/* R READ A PROFILE */
	@GetMapping("/profiles/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<Profile> findById(@PathVariable int id) {
		Profile profile = getProfileService().findById(id).get();
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(profile.getUsers().getId())).withRel("user"));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(profile.getUsers().getId())).withRel("cardTypes"));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(profile.getDocumentstypes().getId())).withRel("docomentTypes"));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(profile.getId())).withSelfRel());
		 return EntityModel.of(profile);
	}

		
	/* U UPDATE A PROFILE */
	@PutMapping("/profiles/update/{id}") //FUNCIONA Junit text pero NO FUNCIONA SPRING BOOT APP 
	//@GetMapping("/profiles/update/{id}") //NO FUNCIONA Junit text pero FUNCIONA SPRING BOOT APP
	@CrossOrigin(origins = "*")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") int profileId, @RequestBody Profile profileDetails) 
			throws ResourceNotFoundException {
		Profile profile = getProfileService().findById(profileId)
	    	    .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + profileId));

		profile.setName(profileDetails.getName());
		profile.setSecond_name(profileDetails.getSecond_name());
		profile.setIdentification(profileDetails.getIdentification());
		profile.setCredit_card(profileDetails.getCredit_card());
		profile.setAddress(profileDetails.getAddress());
		profile.setPostal_code(profileDetails.getPostal_code());
		profile.setCountry(profileDetails.getCountry());
		profile.setEmail(profileDetails.getEmail());
		profile.setCity(profileDetails.getCity());
		profile.setPhone(profileDetails.getPhone());
		profile.setImage(profileDetails.getImage());
		profile.setUsers(profileDetails.getUsers());
		profile.setCardstypes(profileDetails.getCardstypes());
		profile.setDocumentstypes(profileDetails.getDocumentstypes());
	    final Profile updateProfile = getProfileService().save(profile);
	    return ResponseEntity.ok(updateProfile);
	}
		
	/* D DELETE A PROFILES */
	@DeleteMapping("/profiles/delete/{id}") //FUNCIONA Junit text pero NO FUNCIONA SPRING BOOT APP 
	//@GetMapping("/profiles/delete/{id}") //NO FUNCIONA Junit text pero FUNCIONA SPRING BOOT APP
	@CrossOrigin(origins = "*")
	public Map<String, Boolean> deleteExistingProduct(@PathVariable(value = "id") int profileId) 
			throws ResourceNotFoundException {
		Profile profile = getProfileService().findById(profileId)
				.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + profileId));

		getProfileService().delete(profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	/* TOTAL PROFILES */
	@GetMapping("/profiles/count")
	@CrossOrigin(origins = "*")
	public long getprofileCount() {
		return profileService.count();
    }
	
	@GetMapping("/profilesPaginado")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<Profile>> findAllPaginado(@RequestParam int size, @RequestParam int page, @RequestParam String sort){
		   StringTokenizer stringTokenizer =new StringTokenizer(sort,",");
	   Sort orden=Sort.by("a");
	   String campo=stringTokenizer.nextToken();
	   String tipoOrden= stringTokenizer.nextToken();
	   
	   if(tipoOrden.equals("asc"))
			   orden=Sort.by(campo).ascending();
		   else 
			   orden=Sort.by(campo).descending();
		   
		   Pageable pageable=PageRequest.of(page,size,orden);
		   Page<Profile> profile=getProfileService().findAll(pageable);
		   
		   return getPagedResourcesAssembler().toModel(profile,getProfileModelAssembler());
	 }

	/*
	 http://localhost:8080/api/v1/profilesPaginado?size=2&page=0&sort=id,asc
	*/

}
