package once.curso.ejemplojpa.services;

import org.aspectj.weaver.bcel.UnwovenClassFile.ChildClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildRepository;

@Service
@Data
public class ChildService {

	@Autowired
	private ChildRepository childRepository;

	public void dameChildren() {

		Iterable<Child> children = getChildRepository().findAll();
		for (Child child : children) {
			System.out.println(child.getGuys());
			System.out.println(child.getGirls());
		}
	
		
	}

}
