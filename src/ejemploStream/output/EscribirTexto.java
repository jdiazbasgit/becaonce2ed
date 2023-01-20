package ejemploStream.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirTexto {

	// quiero escribir texto en un archivo de disco
	public static void main(String[] args) throws IOException {
		
		try (FileOutputStream fileOutputStream= new FileOutputStream("pepe.txt", true);
				PrintWriter printWriter= new PrintWriter(fileOutputStream);) {
			
			printWriter.println("hola soy una linea de texto");
			printWriter.close();
			printWriter.flush();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		

	}

}
