package ejemploStream.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarImagen {

	public static void main(String[] args) {
<<<<<<< HEAD
		                                                                                                                                         
		try (FileInputStream fileInputStream = new FileInputStream("anillo.jpg");
				FileOutputStream fileOutputStream = new FileOutputStream("segundo aNUILLI.JPG");){
			
			
			byte[] b= new byte[fileInputStream.available()];
=======

		try (FileInputStream fileInputStream = new FileInputStream("anillo.jpg");
				FileOutputStream fileOutputStream = new FileOutputStream("segundo aNUILLI.JPG");) {

			byte[] b = new byte[fileInputStream.available()];
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
			fileInputStream.read(b);
<<<<<<< HEAD
			
			
=======

>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
			fileOutputStream.write(b);
			fileOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		
	}		
=======

	}

>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
}
