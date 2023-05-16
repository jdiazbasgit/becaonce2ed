package once.curso.ejemplojpa.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.entityes.MaritalStatus;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.services.LaboralInformationService;
import once.curso.ejemplojpa.services.MaritalStatusService;
import once.curso.ejemplojpa.services.PersonalInformationService;

@Data
@RestController
@RequestMapping("/once")
public class MaritalStatusesRestController {
	
	@Autowired
	private MaritalStatusService maritalStatusService;
	
	
	@GetMapping("/maritalStatuses")
	public CollectionModel<MaritalStatus> getMaritalStatuses() {
		Iterable<MaritalStatus> maritalStatuses= getMaritalStatusService().findAll();
		maritalStatuses.forEach(m->{
			m.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
					methodOn(MaritalStatusesRestController.class).getMaritalStatusesById(m.getId())).withSelfRel());
		});
		 return CollectionModel.of(maritalStatuses);
	}
	
	@GetMapping("/maritalStatuses/{id}")
	public EntityModel<MaritalStatus> getMaritalStatusesById(@PathVariable int id) {
		 MaritalStatus maritalStatus= getMaritalStatusService().findById(id).get();
		 
		 maritalStatus.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
					methodOn(MaritalStatusesRestController.class).
					getMaritalStatusesById(maritalStatus.getId())).withSelfRel());
		 return EntityModel.of(maritalStatus);
	}

}
