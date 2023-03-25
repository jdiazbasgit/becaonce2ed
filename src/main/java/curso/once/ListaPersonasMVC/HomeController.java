package curso.once.ListaPersonasMVC;

//Ronal y Marche estan estudiando
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		
		
		
		/*@RequestMapping("/lista")
		
		public String lista (Model model)
		
		{
			
			List<String> lista = new ArrayList<String>();
			
			lista.add ("uno");
			lista.add ("dos");
			lista.add ("tres");
			lista.add ("cuatro");
			lista.add ("cinco");
			lista.add ("seis");
			lista.add ("siete");
			lista.add ("ocho");
			lista.add ("nueve");
			lista.add ("diez");
			model.addAttribute("lista", lista);
			return "lista";
			
		}*/
		
	
	}
	
	@RequestMapping("/persona")
	public String lista (Model model) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		/*
		 * personas.add (new Persona ("María", "Ruíz", "10505050M")); personas.add (new
		 * Persona ("Flor:", "López:", "20505050M")); personas.add (new Persona
		 * ("Paco:", "Perez:", "30505050M")); personas.add (new Persona ("Marta:",
		 * "Guerra:", "40505050M")); personas.add (new Persona ("Pepe:", "Racines:",
		 * "50505050M")); personas.add (new Persona ("Juan:", "Narváez:", "60505050M"));
		 * personas.add (new Persona ("Luis:", "Zambrano:", "70505050M")); personas.add
		 * (new Persona ("José:", "Ortega:", "80505050M")); personas.add (new Persona
		 * ("Maria:", "Dávila:", "90505050M")); personas.add (new Persona ("Pedro:",
		 * "Paredes:", "11505050M")); personas.add (new Persona ("Lucía:", "Segura:",
		 * "12505050M")); personas.add (new Persona ("Marina:", "Vazques:",
		 * "13505050M"))
		 ;*/
		
		for (int i=0; i<11; i++) {
			personas.add (new Persona ("María"+i, "Ruíz"+i, "10505050M"+i));
		}
		model.addAttribute("personas", personas);
		return "persona";
		
	}	
}
