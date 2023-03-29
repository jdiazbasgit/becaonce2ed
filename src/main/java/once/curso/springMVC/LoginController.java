package once.curso.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import once.curso.springMVC.beans.Login;

@Controller
public class LoginController {

	@GetMapping("/index")
	public ModelAndView index(ModelAndView modelAndView) {

		// modelAndView.setViewName("index");
		Login login= new Login();
		login.setUsuario("escribe el usuario");
		modelAndView.addObject("login", login);

		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(Login login, ModelAndView modelAndView) {
		modelAndView.setViewName("ko");
		if (login.getUsuario().equalsIgnoreCase("pepe") && login.getClave().equals("1234"))
			modelAndView.setViewName("ok");

		return modelAndView;
	}
}
