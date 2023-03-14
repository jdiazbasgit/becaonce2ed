package cuentaCuento;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import caballero.KnightInterface;
import configuracion.ConfiguraciónSpring;
import exception.SinEspadaException;

public class Cuento {

	public static void main(String[] args) {
		ApplicationContext aventuras = new AnnotationConfigApplicationContext(ConfiguraciónSpring.class);
		KnightInterface knight = (KnightInterface) aventuras.getBean("knigth");
		
		
		try {
			knight.entregarEspada(true);
			knight.embarcar();
		} catch (SinEspadaException e) {
			
		}
		

	}

}
