package concierto.trabajo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.configuracion.ConfiguracionSpring;
import concierto.excepciones.SinSonidoException;
import concierto.musicos.HombreOrquesta;
import concierto.musicos.MusicoInterface;
import concierto.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) throws SinSonidoException {
		ApplicationContext armario = new ClassPathXmlApplicationContext("spring.xml");
		// ApplicationContext armario=new
		// AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		MusicoInterface solista = (MusicoInterface) armario.getBean("federico");

		System.out.println("toca el solista");
		solista.tocar();
		MusicoInterface hombreOrquesta = (MusicoInterface) armario.getBean("hombreOrquesta");
		System.out.println("toca el HombreOrquesta");
		//hombreOrquesta.tocar();

	}

}
