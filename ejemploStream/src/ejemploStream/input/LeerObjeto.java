package ejemploStream.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ejemploStream.output.Agenda;

public class LeerObjeto {


	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("misgentes.agenda");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Agenda misgentes = (Agenda) objectInputStream.readObject();
			System.out.println(misgentes.getNombre()+ " - " +misgentes.getDireccion());
		}
			catch (IOException | ClassNotFoundException e) {
				// TODO: handle exception
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
