package aula;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuración.ConfiguracionSpring;
import exception.SinClaseException;
import profesor.ProfesorInterface;

public class AulaDeClase {

	public static void main(String[] args) {
		ApplicationContext clase = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		ProfesorInterface profe =  (ProfesorInterface) clase.getBean("profesor");
		
		
		try {
			profe.salirDeClase(true);
			profe.comenzarLaClase();
		} catch (SinClaseException e) {
		}
	}

}
