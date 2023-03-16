package concierto.trabajo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.configuracion.ConfiguracionSpring;
<<<<<<< HEAD
import concierto.excepciones.SinSonidoException;
=======
import concierto.exception.SinSonidoException;
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
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
<<<<<<< HEAD
		solista.tocar();
		MusicoInterface hombreOrquesta = (MusicoInterface) armario.getBean("hombreOrquesta");
=======
		try {
			solista.tocar();
		} catch (SinSonidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MusicoInterface hombreOrquesta=(MusicoInterface) armario.getBean("hombreOrquesta");
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
		System.out.println("toca el HombreOrquesta");
<<<<<<< HEAD
		//hombreOrquesta.tocar();
=======
		try {
			hombreOrquesta.tocar();
		} catch (SinSonidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git

	}

}
