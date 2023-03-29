package once.curso.ejemplojpa.services;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildRepository;

@Service
@Data
public class ChildService {
	
	private ChildRepository childRepository;
	public void dameJovenes() {
		Iterable<Child> jovenes= getChildRepository().findAll();
		for (Child child : jovenes) {
			System.out.println(child.getClass());
		}
	}
	
	public String[] dameJovenes(String filtro) {	
return getChildRepository().dameChildren(filtro);
}
}
