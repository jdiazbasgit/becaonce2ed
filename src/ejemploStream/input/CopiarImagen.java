package ejemploStream.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarImagen {

	public static void main(String[] args) {

		
	try (FileInputStream fileInputStream=new FileInputStream("anillo.jpg");
				FileOutputStream fileOutputStream=new FileOutputStream("segundo aNUILLI.JPG");) {

			byte[] b= new byte[fileInputStream.available()];

			fileInputStream.read(b);

			fileOutputStream.write(b);
			fileOutputStream.flush();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		
		}

	}


