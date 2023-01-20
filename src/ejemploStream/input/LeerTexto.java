package ejemploStream.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerTexto {

	public static void main(String[] args) {
		FileInputStream fileInputStream= null;
		try {
			fileInputStream = new FileInputStream("mitexto.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			while(bufferedReader.ready()) {
				String asciiTotexto = Character.toString((char)bufferedReader.read());
				//System.out.println(bufferedReader.readLine());
				//System.out.println(bufferedReader.read());
				System.out.print(asciiTotexto);
				
				//System.out.println("siguiente linea");
			}
		} catch (IOException e) {
			
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