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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.javafx.geom.AreaOp.AddOp;

import lombok.Data;

@Data
@Controller
public class HomeController {
	private String nombre;
	private int telefono;
	private int dni;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/ejemplo")
	public String texto(Model model, @RequestParam String  texto) {
		
		String salida = "has escrito "+ texto.toUpperCase()+"y tiene " + texto.length()+ "letras ";
		model.addAttribute("salida", salida);
		
		return "texto";
		
	}
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		List<String> lista = new ArrayList<String>();
		lista.add("uno");
		lista.add("dos");
		lista.add("tres");
		lista.add("cinco");
		lista.add("seis");
		lista.add("siete");
		lista.add("ocho");
		lista.add("nueve");
		lista.add("diez");
		
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	@RequestMapping("/persona")
	public void persona(Model model) {
		
		List<String> nombre = new ArrayList<String>();
		nombre.add("jose");
		nombre.add("maria");
		nombre.add("sofia");
		model.addAttribute("nombre", nombre);
		
		List<Integer> telefono = new ArrayList<Integer>();
		telefono.add(000230501);
		telefono.add(465479871);
		telefono.add(789451236);
		model.addAttribute("telefono", telefono);
		
		List<String> dni = new ArrayList<String>();
		dni.add("Y3216547X");
		dni.add("08000102D");
		dni.add("78965211X");
		model.addAttribute("dni", dni);
		
		
		return "nombre", "telefono", "dni";
		
	}
	
}
