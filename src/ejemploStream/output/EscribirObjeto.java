package ejemploStream.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjeto {

	public static void main(String[] args) {

		try (FileOutputStream fileOutputStream= new FileOutputStream("pepe.agenda");)
		{
			ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
			Agenda pepe= new Agenda();
			pepe.setNombre("pepe garcia");
			pepe.setDireccion("calle del pez,4");
			pepe.setTelefono("654654654");
			objectOutputStream.writeObject(pepe);
			objectOutputStream.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
