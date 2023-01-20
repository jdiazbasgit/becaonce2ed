package ejemploStream.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerTexto {

	public static void main(String[] args) {
		
		
		try(FileInputStream fileInputStream= new FileInputStream("index.html"); ) {

			InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
			while(bufferedReader.ready()) {
				System.out.println(bufferedReader.readLine());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}

}
