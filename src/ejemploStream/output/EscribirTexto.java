package ejemploStream.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirTexto {


	public static void main(String[] args) {
		
		try  (
				FileOutputStream fileOutputStream = new FileOutputStream("mitexto.txt",true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);)		
		{			
			printWriter.println("escribiendoooooooo");
			printWriter.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
