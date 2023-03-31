package once.curso.ejemplojpa;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.services.ChildService;

@SpringBootTest
@Data
class ChildTest {
	@Autowired
	private ChildService childService;
	@Test
	public void findAll() {
		List<Child> hijos = (List<Child>) getChildService().findAll();
		assertNotEquals(hijos.size(), 0);
	}

}