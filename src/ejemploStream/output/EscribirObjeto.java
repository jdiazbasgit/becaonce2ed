package ejemploStream.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class EscribirObjeto {


	public static void main(String[] args) {
				
		try (
				FileOutputStream fileOutputStream = new FileOutputStream("misgentes.agenda");
				)
		
		{
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			Agenda agendaDePrueba = new Agenda();
			System.out.println("Escribe el nombre");
			agendaDePrueba.setNombre(leerTeclado());
			agendaDePrueba.setTlf("6757654765");
			agendaDePrueba.setDireccion("calle loca");
			objectOutputStream.writeObject(agendaDePrueba);
			objectOutputStream.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static String leerTeclado() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
