package once.curso.ejemplojpa.services;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Children;
import once.curso.ejemplojpa.repositories.ChildrenCRUDRepository;

@Service
@Data
public class ChildrenService {
	
	private ChildrenCRUDRepository childrenCRUDRepository;
	
	public Iterable<Children> getDatosLaborales(){
		
		return getChildrenCRUDRepository().findAll();
	}

}
