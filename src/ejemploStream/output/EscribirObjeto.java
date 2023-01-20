package ejemploStream.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class EscribirObjeto {

	public static void main(String[] args) {

		try (FileOutputStream fileOutputStream= new FileOutputStream("pepe.agenda");
				ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);){
			

			Agenda pepe= new Agenda();
			System.err.println("escribe nombre:");
			pepe.setNombre(leerTeclado());
			pepe.setDireccion("calle del pez,4");
			pepe.setTelefono("654654654");
			objectOutputStream.writeObject(pepe);
			objectOutputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	
	public static String leerTeclado() {
		Scanner scanner= new Scanner(System.in);
		return scanner.nextLine();
	}

}
