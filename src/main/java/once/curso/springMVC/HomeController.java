package once.curso.springMVC;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger loger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate);
	 * 
	 * return "home"; }
	 */

	@RequestMapping("/personas")
	public ModelAndView lista(ModelAndView modelAndView) {
		List<Persona> personas = new ArrayList<Persona>();
		for (int i = 0; i < 10; i++) {
			String nombreLista = "Nombre" + i;
			String apellidosLista = "Apellido" + i;
			String telefonoLista = "60000000" + i;
			Persona persona = new Persona(nombreLista, apellidosLista, telefonoLista);
			personas.add(persona);
			modelAndView.addObject("personas", personas);
		}
		return modelAndView;


	}

}
