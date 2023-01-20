package ejemploStream.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarImagen {

	public static void main(String[] args) {
		FileInputStream fileInputStream= null;
		FileOutputStream fileOutputStream= null;
		try {
			fileInputStream= new FileInputStream("Aliens.jpg");
			byte[] b= new byte[fileInputStream.available()];
			fileInputStream.read(b);
			
			fileOutputStream= new FileOutputStream("CopiaAliens.JPG");
			fileOutputStream.write(b);
			fileOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				

	}

}