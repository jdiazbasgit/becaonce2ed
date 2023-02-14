import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
			try {
				ServerSocket serverSocket= new ServerSocket(5000);
				
				while(true) {
					Socket socket= serverSocket.accept();
					BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
					InetAddress inetAddress = socket.getInetAddress();
					System.out.println(inetAddress.getHostAddress()+ "dice: "+ br.readLine());	
					socket.close();
					}
			} catch (IOException e) {
				
				
				e.printStackTrace();
			}
	

	}
}


