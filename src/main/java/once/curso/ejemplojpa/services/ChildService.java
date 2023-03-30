package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildRepository;

@Service
@Data
public class ChildService {
	
	@Autowired
	private ChildRepository childrenRepository;
	
	public void dameHijos() {
		Iterable<Child> hijos= getChildrenRepository().findAll();
		for (Child children : hijos) {
			System.out.println(children.getGuys());
			System.out.println(children.getGirl());
			
		}
	}
}
