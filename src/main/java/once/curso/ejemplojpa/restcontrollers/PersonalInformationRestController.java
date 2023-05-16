package once.curso.ejemplojpa.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.services.LaboralInformationService;
import once.curso.ejemplojpa.services.PersonalInformationService;

@Data
@RestController
@RequestMapping("/once")
public class PersonalInformationRestController {
	
	@Autowired
	private PersonalInformationService personalInformationService;
	
	
	@GetMapping("/personalInformations")
	public CollectionModel<PersonalInformation> getPersonalInformation() {
		 Iterable<PersonalInformation> personalInformations= getPersonalInformationService().findAll();
		 personalInformations.forEach(p->{
			 p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class)
					 .getChildrenById(p.getChildren().getId())).withRel("child"));
			 
			 p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MaritalStatusesRestController.class)
					 .getMaritalStatusesById(p.getMaritalStatus().getId())).withRel("maritalStatus"));
			 
			 p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonalInformationRestController.class)
					 .getPersonalInformationById(p.getId())).withSelfRel());
		 });
		 
		 return CollectionModel.of(personalInformations);
	}
	
	@GetMapping("/personalInformations/{id}")
	public PersonalInformation getPersonalInformationById(@PathVariable int id) {
		return getPersonalInformationService().findById(id).get();
	}

}
