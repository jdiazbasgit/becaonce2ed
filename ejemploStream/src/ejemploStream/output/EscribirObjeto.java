package ejemploStream.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjeto {


	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream("misgentes.agenda");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			Agenda agendaDePrueba = new Agenda();
			agendaDePrueba.setNombre("mariano");
			agendaDePrueba.setTlf("6757654765");
			agendaDePrueba.setDireccion("calle loca");
			objectOutputStream.writeObject(agendaDePrueba);
			objectOutputStream.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
