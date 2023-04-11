package once.curso.springMVC;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import clase.persona.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 *  En el value del RequestMapping pones el nombre de la url como la que queremos que se llame 
	 */
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/ejemplo")
	public String texto(Model model, @RequestParam String texto) {
		String salida= "Has escrito " + texto.toUpperCase() + " y tiene " + texto.length() + " letras ";
		
		model.addAttribute("salida", salida);
		
		return "texto";
		
	}
	
	
	@RequestMapping("/lista")
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
	
	model.addAttribute("lista", lista);
	
	return "lista";	
		
	}
	
	//@SuppressWarnings("unused")
	@RequestMapping("/listapersona")
	
	public  String listapersona (Model model) {
		
		List<Persona> listapersona = new ArrayList<Persona>();
		
	   for(int i=0; i<10 ;i++) {
		   
		   String nombre =JOptionPane.showInputDialog("introduce tu nombre por favor ") +i;
		   String dni="Dni" + i;
		   String telefono = "telefono"+i;
		    Persona persona = new Persona(nombre,dni,telefono);
		    listapersona.add(persona); 
		    
		    // listapersona.add(new Persona("pepe"+i, "12345678O"+i, "987654321"+i));
	   }
	   
	  model.addAttribute("listapersona",listapersona);
	return "listapersona";
	
	}
}
	
