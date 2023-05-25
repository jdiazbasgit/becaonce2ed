package once.curso.proyectobanco.restcontrollers;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.models.FeeModelAssembler;
import once.curso.proyectobanco.services.FeeService;

@RestController
@Data
@RequestMapping("/once")
public class FeeRestController {
	
	@Autowired
	private FeeModelAssembler feeModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<Fee> pagedResourcesAssembler;

	@Autowired
	private FeeService feeService;
	
	@GetMapping(value = "/fees/{id}")
	public EntityModel<Fee> findById(@PathVariable Integer id) {
		Fee fee=  getFeeService().findById(id).get();
		fee.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class)
				.findById(fee.getId())).withSelfRel());
		 return EntityModel.of(fee);
	}
	
//	@GetMapping(value = "/fees")
//	public CollectionModel<Fee> findAll(){
//		Iterable<Fee> fees= getFeeService().findAll();
//		fees.forEach(f->{
//			f.add(WebMvcLinkBuilder.
//					linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class).
//							findById(f.getId())).withSelfRel());
//		});
//		 
//		 return CollectionModel.of(fees);
//	}
	
	@GetMapping(value = "/fees")
	public PagedModel<EntityModel<Fee>> findAll(@RequestParam (defaultValue = "0") int size, @RequestParam (defaultValue = "0") int page, @RequestParam (required = false) String sort){
		if (size == 0) {
			size = (int) getFeeService().count();
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
		Page<Fee> fee = getFeeService().findAll(pageable);
		 
		 return getPagedResourcesAssembler().toModel(fee,getFeeModelAssembler());
	}
	
	@PatchMapping(value = "/fees")
	public Iterable<Fee> findAllById(@RequestBody List<Integer> ids) {
		return getFeeService().findAllById(ids);
	}
	
	@PostMapping("/fees")
	public Fee save(@RequestBody Fee fee) {
		return getFeeService().save(fee);
	}
	
	@PutMapping("/fees")
	public List <Fee> saveAll(@RequestBody List<Fee> fees) {
		return (List<Fee>) getFeeService().saveAll(fees);
	}

	@DeleteMapping("/fees/{id}")
	public void deleteById(@PathVariable int id) {
		getFeeService().deleteById(id);
	}	
}