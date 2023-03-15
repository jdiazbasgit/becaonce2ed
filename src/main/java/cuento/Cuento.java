package cuento;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import caballero.CaballeroInterface;
import configuracion.Configuracion;
import excepciones.SinEspadaException;

public class Cuento {

	public static void main(String[] args) throws SinEspadaException {

	ApplicationContext libroDeCuentos = new AnnotationConfigApplicationContext(Configuracion.class);
	CaballeroInterface caballero = (CaballeroInterface) libroDeCuentos.getBean("caballero");
	
	caballero.embarcar();
		
	}

}
