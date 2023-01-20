package ejemploStream.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirTexto {

	// quiero escribir texto en un archivo de disco
<<<<<<< HEAD
	public static void main(String[] args) {

		try (FileOutputStream fileOutputStream = new FileOutputStream("pepe.txt", true);) {

			PrintWriter printWriter = new PrintWriter(fileOutputStream);
=======
	public static void main(String[] args) throws IOException {
		
		try (FileOutputStream fileOutputStream= new FileOutputStream("pepe.txt", true);
				PrintWriter printWriter= new PrintWriter(fileOutputStream);) {
			
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
			printWriter.println("hola soy una linea de texto");
			printWriter.close();
			printWriter.flush();
<<<<<<< HEAD
		} catch (IOException e) {
			// TODO Auto-generated catch block
=======
		} catch (FileNotFoundException e) {
		
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
			e.printStackTrace();
		}
<<<<<<< HEAD
=======
		
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git

	}

}
