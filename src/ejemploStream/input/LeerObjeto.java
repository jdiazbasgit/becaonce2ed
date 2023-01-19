package ejemploStream.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ejemploStream.output.Agenda;

public class LeerObjeto {

	public static void main(String[] args) {
		FileInputStream fileInputStream=null;
		try {
			fileInputStream= new FileInputStream("pepe.agenda");
			ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
			Agenda pepe= (Agenda) objectInputStream.readObject();
			System.out.println(pepe.getNombre()+" - "+pepe.getDireccion()+" - "+pepe.getTelefono());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
