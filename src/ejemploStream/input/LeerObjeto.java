package ejemploStream.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ejemploStream.output.Agenda;

public class LeerObjeto {

	public static void main(String[] args) {
<<<<<<< HEAD

		try (FileInputStream fileInputStream = new FileInputStream("pepe.agenda");) {

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Agenda pepe = (Agenda) objectInputStream.readObject();
			System.out.println(pepe.getNombre() + " - " + pepe.getDireccion() + " - " + pepe.getTelefono());
=======
		
		try (FileInputStream fileInputStream= new FileInputStream("pepe.agenda");
				ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);) {
			
			Agenda pepe= (Agenda) objectInputStream.readObject();
			System.out.println(pepe.getNombre()+" - "+pepe.getDireccion()+" - "+pepe.getTelefono());
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
=======
		
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git

	}

}
