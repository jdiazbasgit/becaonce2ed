package aventura.narrador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aventura.caballeros.DarkKnight;
import aventura.caballeros.KnightInterface;
import aventura.configuracion.ConfiguracionSpring;
import aventura.excepciones.SinEspadaException;

public class Cancion {

	public static void main(String[] args) {
		ApplicationContext libroDeCuentos = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		KnightInterface darkKnight = (KnightInterface) libroDeCuentos.getBean("darkKnight");
		try {
			darkKnight.entregarEspada(true);
			darkKnight.embarcar();
						
		} catch (SinEspadaException e) {
			
		}
		
		
	}

}
