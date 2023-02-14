import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Cliente {

	public static void main(String[] args) {
		
		String ip ="192.168.10.178";
		try {
			Socket socket = new Socket(ip,5000);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println("has entendido algo");
			printWriter.flush();
			socket.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	

	}

}
