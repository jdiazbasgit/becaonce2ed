package panaderia.panaderiaMain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import panaderia.configuracion.ConfiguracionSpring;
import panaderia.excepciones.PanCrudoException;
import panaderia.panaderos.PanaderoInterface;

public class Panaderia {

	public static void main(String[] args) {
		
		ApplicationContext libroDeRecetas = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		PanaderoInterface panadero = (PanaderoInterface) libroDeRecetas.getBean("panadero");
		VaciarLog("log.txt");
		
		try {
			System.out.println(Arrays.asList(libroDeRecetas.getBeanDefinitionNames()));
			panadero.hornear(2000);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("notepad.exe log.txt");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		((AbstractApplicationContext) libroDeRecetas).close(); // Esta línea cerraría el leak, por sugerencia del IDE
	}
	
	public static void VaciarLog(String archivo) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
