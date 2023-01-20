package ejemploStream.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerTexto {

	public static void main(String[] args) {
<<<<<<< HEAD

		try (FileInputStream fileInputStream = new FileInputStream("index.html");) {

			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			while (bufferedReader.ready()) {
=======
		
		try (FileInputStream fileInputStream= new FileInputStream("index.html");
				InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
				BufferedReader bufferedReader= new BufferedReader(inputStreamReader);) {
			
			while(bufferedReader.ready()) {
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git
				System.out.println(bufferedReader.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
=======
		
		
>>>>>>> branch 'ejemploStream' of https://github.com/jdiazbasgit/becaonce2ed.git

	}

}
