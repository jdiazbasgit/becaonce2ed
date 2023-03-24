package once.curso.persona;

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

import once.curso.persona.beans.PersonaMVC;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/lista")
	public String lista (Model model) {
	    List<PersonaMVC> listaPersonas = new ArrayList<PersonaMVC>();
	        listaPersonas.add(new PersonaMVC("Juan", "Pérez", "111111111"));
	        listaPersonas.add(new PersonaMVC("María", "García", "222222222"));
	        listaPersonas.add(new PersonaMVC("Pedro", "Martínez", "333333333"));
	        listaPersonas.add(new PersonaMVC("Pepe", "Martoche", "444444444"));
	        listaPersonas.add(new PersonaMVC("Pelon", "Marleche", "5555555555"));
	        listaPersonas.add(new PersonaMVC("Pepa", "Mar", "6666666666"));
	        listaPersonas.add(new PersonaMVC("Peto", "Martirios", "7777777777"));
	        listaPersonas.add(new PersonaMVC("Petanca", "Maradona", "88888888888"));
	        listaPersonas.add(new PersonaMVC("Pedrosca", "Marojo", "99999999999"));
	        listaPersonas.add(new PersonaMVC("Peliana", "Martillo", "0000000000"));
	        model.addAttribute("listaPersonas", listaPersonas);
	    return "listaPersonas";
	    }
	   
}
