package once.curso.springMVC;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //La url es la root / y hará un forward a home.jsp
	//http://localhost:8080/springMVC/
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //es como hacer un forward a home.jsp, en la home le diremos por html que muestre la variable serverTime
	}
	
	//añadimos otro reques, otra url
	@RequestMapping(value = "/prueba") //hará un forward a prueba.jsp 
	//por defecto entra en GET y por seguiridad se creó directamente las anotaciones @GetMapping y @PostMapping pero requieren version 
	//http://localhost:8080/springMVC/prueba.jsp
	public String prueba(@RequestParam String textoRecibido, Model model) {
		
		String saludo = "Hola "+textoRecibido+" tu nombre tiene "+textoRecibido.length()+" letras";
		
		model.addAttribute("saludar", saludo );
		
		return "prueba"; //es como hacer un forward a home.jsp, en la home le diremos por html que muestre la variable serverTime
	}
	
	//más moderno y simple es juntar Vista (view) y modelo:
	@GetMapping("/home2")
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //es como hacer un forward a home.jsp, en la home le diremos por html que muestre la variable serverTime
	}
}
