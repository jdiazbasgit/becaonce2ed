package once.curso.proyectobanco;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import once.curso.proyectobanco.threads.BancoThread;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	
		return application.sources(ProyectoBancoApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("arranco");
	}
	
	

}
