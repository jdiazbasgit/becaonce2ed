package once.curso.SpringMVC;

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

import once.curso.beans.Persona;

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
	//http://localhost:8080/springMVC/  ---> home.jsp
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //es como hacer un forward a home.jsp, en la home le diremos por html que muestre la variable serverTime
		//no le decimos home.jsp porque el suffix ya lo definimos en el context.xml
	}
	
	
	//--------------------------------------------------------------------
	
	//añadimos otro reques, otra url
	@RequestMapping(value = "/prueba") //hará un forward a prueba.jsp 
	//por defecto entra en GET y por seguiridad se creó directamente las anotaciones @GetMapping y @PostMapping pero requieren version 
	//http://localhost:8080/springMVC/prueba.jsp
	public String prueba(@RequestParam String textoRecibido, Model model) {
		
		String saludo = "Hola "+textoRecibido+" tu nombre tiene "+textoRecibido.length()+" letras";
		
		model.addAttribute("saludar", saludo );
		
		return "prueba"; //es como hacer un forward a home.jsp, en la home le diremos por html que muestre la variable serverTime
	}//la dirección sería algo como: http://localhost:8080/springMVC/prueba?textoRecibido=Paco
	
	//---------------------------------------------------------------------
	
	
	
	
	
	@RequestMapping(value = "/listado")
	public String lista (Model model) {
		
		List<String> lista = new ArrayList<String>();
		lista.add("uno");
		lista.add("dos");
		lista.add("tres");
		lista.add("cuatro");
		lista.add("cinco");
		lista.add("seis");
		lista.add("siete");
		lista.add("ocho");
		lista.add("nueve");
		lista.add("diez");
				
		model.addAttribute("propiedadLista", lista);
		
		return "listado";
	}
	
	
	//---------------------------------------------------------------------
	
	
	
	@RequestMapping(value = "/listadoConPersonas")
	public Object grupoDePersonasMetodo (@RequestParam int numeroPersonas, Model model) {
		
		List<Persona> grupoDePersonas = new ArrayList<Persona>();
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < numeroPersonas; i++) {
			String nombreNuevo = "Persona"+i;
			String dniNuevo = "0000000"+Integer.toString(i) + letras.charAt(i%letras.length());
			if (i>9)
			dniNuevo = dniNuevo.substring(Integer.toString(i).length()-1);
			String telefonoNuevo = Integer.toString(600000000 + i);
			grupoDePersonas.add(new Persona(nombreNuevo,dniNuevo,telefonoNuevo));
		}
						
		model.addAttribute("propiedadGrupoPersonas", grupoDePersonas);		
		return "listadoConPersonas";
	}
	
	
	//---------------------------------------------------------------------
	//más moderno y simple es juntar Vista (view) y modelo:
	//@GetMapping("/home2")
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //es como hacer un forward a home.jsp, en la home le diremos por html que muestre la variable serverTime
	}
}
