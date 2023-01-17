package concierto;
import java.nio.file.ClosedDirectoryStreamException;

public class EjemploSingleton {

	public static void main(String[] args) {
		
		DirectorDeOrquestaSingleton director= DirectorDeOrquestaSingleton.getInstance();
		
		director.setNombre("federico");
		
		DirectorDeOrquestaSingleton director1= DirectorDeOrquestaSingleton.getInstance();
		
		DirectorDeOrquestaSingleton manuel= DirectorDeOrquestaSingleton.getInstance();
		
		System.out.println(director1.getNombre());
		
		director1.setNombre("Javier");
		
		System.out.println("el nombre de manuel es:"+manuel.getNombre());
		
		System.out.println("El nombre de director es:"+director.getNombre());
	}

}
