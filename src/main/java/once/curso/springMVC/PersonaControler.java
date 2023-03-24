package once.curso.springMVC;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonaControler {

	private static final Logger loger = LoggerFactory.getLogger(PersonaControler.class);

@RequestMapping ("/persona")
public String lista (Model model) {
	
	List<Persona> personas = new ArrayList<Persona>();
		for (int i=0;i<15;i++) {
		String nombreLista="nombre" + i;
		String apellidosLista="apellidos" + i;
		String telefonoLista= "654987123"+ i;
		Persona persona = new Persona (nombreLista, apellidosLista, telefonoLista);
		personas.add(persona);
		model.addAttribute("lista", personas);
	
		
	}
		return "persona";
	}
}

