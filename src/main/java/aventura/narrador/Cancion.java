package aventura.narrador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import aventura.caballeros.KnightInterface;
import aventura.configuracion.ConfiguracionSpring;
import aventura.excepciones.SinEspadaException;

public class Cancion {

	public static void main(String[] args) {
		ApplicationContext libroDeCuentos = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		KnightInterface darkKnight = (KnightInterface) libroDeCuentos.getBean("darkKnight");
		VaciarLog("log.txt");
		
		try {
			//System.out.println(Arrays.asList(libroDeCuentos.getBeanDefinitionNames()));
			darkKnight.entregarEspada(true);
			darkKnight.ajustarSleep(400);
			darkKnight.embarcar();
			//darkKnight.matarAlDragon();
			Runtime rt = Runtime.getRuntime();
			try {
				//rt.exec("C:\\Windows\\System32\\notepad.exe C:\\Proyectos\\modulo2\\AventuraAspectos\\aventura\\log.txt");
				rt.exec("notepad.exe log.txt");
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (SinEspadaException e) {

		}
		((AbstractApplicationContext) libroDeCuentos).close(); // Esta l�nea cerrar�a el leak, por sugerencia del IDE
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
