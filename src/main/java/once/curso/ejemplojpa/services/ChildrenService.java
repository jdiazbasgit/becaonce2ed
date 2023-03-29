package once.curso.ejemplojpa.services;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildrenRepository;

@Service
@Data
public class ChildrenService {
	
	private ChildrenRepository childrenRepository;
	public void dameChild() {
		Iterable<Child> jovenes= getChildrenRepository().findAll();
		for (Child child : jovenes) {
			System.out.println(child.getClass());
		}
	}
	
	public String[] dameChild(String filtro) {	
return getChildrenRepository().dameChildren(filtro);
}
}
