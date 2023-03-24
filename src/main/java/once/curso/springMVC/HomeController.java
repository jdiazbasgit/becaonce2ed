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
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> 443d389361fbd58b42b3d099f7468655df53bcff
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
<<<<<<< HEAD
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

=======
	//@RequestMapping(value = "/somoslosmejores", method = RequestMethod.GET)
	
	@GetMapping("/somoslosmejores")
	public ModelAndView home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ModelAndView modelAndView= new ModelAndView("home");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		modelAndView.addObject("serverTime", "esta es la fecha:"+formattedDate );
		
		return modelAndView;
	}
	
	@GetMapping("/curso")
	public String curso(@RequestParam("valor") String texto,Model model) {
		
		String salida="Has escrito "+texto.toUpperCase()+ " y tiene "+texto.length()+" letras";
		model.addAttribute("salida",salida);
		
		return "curso";
	}
	
	@GetMapping("/curso/{valor}")
	public ModelAndView curso1(@PathVariable("valor") String texto) {
		
		ModelAndView modelAndView= new ModelAndView("curso");
		String salida="Has escrito "+texto.toUpperCase()+ " y tiene "+texto.length()+" letras en url friendly";
		modelAndView.addObject("salida",salida);
		
		return modelAndView;
	}
	
	
	@GetMapping("nombre/{nombre}/{apellido}")
	public ModelAndView nombre(@PathVariable String nombre,@PathVariable String apellido) {
		
		ModelAndView modelAndView= new ModelAndView("curso");
		
		String salida="Te llamas "+nombre+" "+apellido;
		modelAndView.addObject("salida", salida);
		
>>>>>>> 443d389361fbd58b42b3d099f7468655df53bcff
		return modelAndView;
	}

}
