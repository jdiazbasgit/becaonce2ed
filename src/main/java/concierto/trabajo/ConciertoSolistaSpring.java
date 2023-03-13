package concierto.trabajo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.configuracion.ConfiguracionSpring;
import concierto.exception.SinSonidoException;
import concierto.musicos.HombreOrquesta;
import concierto.musicos.MusicoInterface;
import concierto.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		ApplicationContext armario= new ClassPathXmlApplicationContext("spring.xml");
		//ApplicationContext armario=new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		MusicoInterface solista= (MusicoInterface) armario.getBean("federico");
		
		//solista.getInstrumento().setSonido("dfghfghdgdfghdfhdfg");
		System.out.println("toca el solista");
		try {
			solista.tocar();
		} catch (SinSonidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MusicoInterface hombreOrquesta=(MusicoInterface) armario.getBean("hombreOrquesta");
		System.out.println("toca el HombreOrquesta");
		try {
			hombreOrquesta.tocar();
		} catch (SinSonidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
