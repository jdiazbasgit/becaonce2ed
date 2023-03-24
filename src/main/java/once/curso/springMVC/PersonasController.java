package once.curso.springMVC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonasController {
	@GetMapping(path="/personas")
	public String datospersonales(Model model) {
		
		List<DatosPersonales> listaDatosPersonales = new ArrayList<DatosPersonales>();
		listaDatosPersonales.add(new DatosPersonales("Sonia", "Benito", "69612555"));
		listaDatosPersonales.add(new DatosPersonales("Silvia", "Pastor", "69656966"));
		listaDatosPersonales.add(new DatosPersonales("Alfredo", "Caño", "69654966"));
		
		model.addAttribute("lista",listaDatosPersonales);
		return "personas";
	}
	
	
}
