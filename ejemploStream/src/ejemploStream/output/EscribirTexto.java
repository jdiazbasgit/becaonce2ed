package ejemploStream.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirTexto {


	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("mitexto.txt",true);
			PrintWriter printWriter = new PrintWriter(fileOutputStream);
			printWriter.println("escribiendoooooooo");
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		


	}

}
