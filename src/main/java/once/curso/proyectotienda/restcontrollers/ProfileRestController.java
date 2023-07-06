package once.curso.proyectotienda.restcontrollers;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.dtos.ProfileDto;
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
	@PostMapping("/profiles")
	@CrossOrigin(origins = "*")
	public Profile createProfile(@RequestBody Profile newProfile) {
		return getProfileService().save(newProfile);
	}
	
	/* R READ ALL PROFILE */
	@GetMapping("/profiles")
	@CrossOrigin(origins = "*")
	public CollectionModel<Profile> getProfile() {
		Iterable<Profile> profile = getProfileService().findAll();
		profile.forEach(p->{
			 p.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(p.getUser().getId()))
					 .withRel("user"));
			 p.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(p.getCardType().getId()))
					 .withRel("cardTypes"));
			 p.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(p.getDocumentType().getId()))
					 .withRel("documentTypes"));
			 p.add(WebMvcLinkBuilder
					 .linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(p.getId()))
					 .withSelfRel());
		 });
		 return CollectionModel.of(profile);
	}	
	
	/* R READ A PROFILE */
	@GetMapping("/profiles/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<Profile> findById(@PathVariable int id) {
		Profile profile = getProfileService().findById(id).get();
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
				.findById(profile.getUser().getId())).withRel("user"));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class)
				.findById(profile.getUser().getId())).withRel("cardTypes"));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class)
				.findById(profile.getDocumentType().getId())).withRel("documentTypes"));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
				.findById(profile.getId())).withSelfRel());
		 return EntityModel.of(profile);
	}

		
	/* U UPDATE A PROFILE ESTO ES PARA JBDC*/
	//@PutMapping("/profiles/{id}") //SPRING BOOT 
	//@GetMapping("/profiles/update/{id}") //Junit text
	/*@CrossOrigin(origins = "*")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") int profileId, 
			@RequestBody Profile profileDetails) throws ResourceNotFoundException {
		Profile profile = getProfileService().findById(profileId).get();
	    	    //.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + profileId));

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
		profile.setUser(profileDetails.getUser());
		profile.setCardtType(profileDetails.getCardtType());
		profile.setDocumentType(profileDetails.getDocumentType());
		
	    final Profile updateProfile = getProfileService().save(profile);
	    return ResponseEntity.ok(updateProfile);
	}*/
		
	/* D DELETE A PROFILES */
	@DeleteMapping("/profiles/{id}") //SPRING BOOT
	//@GetMapping("/profiles/delete/{id}") //Junit text
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
	
	/*@PatchMapping("/profiles/comprobar")
	public ProfileUserDto getProfileUserDto(@RequestBody ProfileUserDtoString profileUserDtoString ) {
		return getProfileService().getProfileUserDto(profileUserDtoString.getIdentification(),profileUserDtoString.getUser(),profileUserDtoString.getPhone(),profileUserDtoString.getEmail(), profileUserDtoString.getCreditcard());
	}
	
	@PostMapping("/profiles")
	public boolean save(@RequestBody Profile profile) {
		return getProfileService().existsById(getProfileService().save(profile).getId());
	}*/
	
	@PutMapping("/profiles")@CrossOrigin(origins = "*")
	public List <Profile> saveAll(@RequestBody List<Profile> profiles) {
		return (List<Profile>) getProfileService().saveAll(profiles);
	}

	/*@DeleteMapping("/profiles/{id}")
	public boolean deleteById(@PathVariable int id) {
		getProfileService().deleteById(id);
		return getProfileService().existsById(id);
	}*/
	
	@PostMapping("/profiles/{id}")
	@CrossOrigin(origins = "*")
	public boolean existsById(@PathVariable int id) {
		return getProfileService().existsById(id);
	}
	
	/* PatchMapping es una anotación en Spring Framework que se utiliza para mapear una solicitud PATCH HTTP a un método de controlador en la aplicación.
	 * El método anotado con @PatchMapping manejará las solicitudes PATCH que coincidan con la URL especificada en la anotación. Puedes definir la URL 
	 * utilizando una cadena de texto o una expresión de plantilla, similar a otras anotaciones de mapeo como @GetMapping o @PostMapping.
	 * Aquí tienes un ejemplo de cómo se puede usar @PatchMapping en un controlador de Spring: */
	@PatchMapping("/profiles")
	@CrossOrigin(origins = "*")
	public Profile crearProfile(@RequestBody ProfileDto profileDto) {		
		 return getProfileService().crearProfile(profileDto);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	/*
	 * BACK
	 * -restcontrolador --> pach 
	 * -service --> profileUserDto 
	 * -CRUD --> getProfileUserDto
	 * 
	 * ProfileResController -> ProfileService ->  ProfileCRUDRepository -> ProfileDto, ProfileUserDto, Profile
	 * 
	 * http://localhost:8080/api/v1/profilesPaginado?size=2&page=0&sort=id,asc
	*/

}