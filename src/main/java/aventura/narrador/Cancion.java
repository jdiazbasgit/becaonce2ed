package aventura.narrador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aventura.caballeros.CaballeroInterface;
import aventura.configuracion.ConfiguracionSpring;
import aventura.excepciones.SinEspadaException;

public class Cancion {

	public static void main(String[] args) {
		ApplicationContext libroDeCuentos = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		CaballeroInterface caballero = (CaballeroInterface) libroDeCuentos.getBean("caballero");
		try {
			caballero.entregarEspada(true);
			caballero.embarcar();
						
		} catch (SinEspadaException e) {
			
		}
		
		
	}
}
