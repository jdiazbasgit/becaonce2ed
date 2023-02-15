package chat.recepciones;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import chat.ChatGridBag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Servidor extends Thread {
	public static final int PUERTO_ESCUCHA_REGISTRO_SERVIDOR = 5000;
	public static final int PUERTO_ESCUCHA_MENSAJE_SERVIDOR = 5002;

	//public static final int PUERTO_ENVIO_REGISTRO_SERVIDOR = 5003;
	public static final int PUERTO_ENVIO_MENSAJE_SERVIDOR = 5003;

	public static final int PUERTO_ESCUCHA_BAJA_SERVIDOR=5004;

	public static Map<String, String> usuarios= new HashMap<>();
	public static Map<String, String> mensajes= new HashMap<>();

	private int puerto;
	private ChatGridBag chat;
	
	
	@Override
	public void run() {
		try {
			//LFRM-BORRAR
			System.out.println("DESDE SERVIDOR - getpuerto: "+getPuerto());
			ServerSocket serverSocket=new ServerSocket(getPuerto());
			while (true) {
				Socket socket= serverSocket.accept();
					hacerAlgo(socket);
					socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public abstract void hacerAlgo(Socket socket);

	
	public String leerMensaje(Socket socket) throws Exception {
		try(BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			return bufferedReader.readLine();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Object leerObjeto(Socket socket) throws Exception {
		try(ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream())) {
			return objectInputStream.readObject();
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void leerArchivo(Socket socket, String nombre,int cantidad) throws Exception {
		try(FileOutputStream fileOutputStream= new FileOutputStream(nombre)) {
			byte[] b= new byte[cantidad];
			for (int i = 0; i < cantidad; i++) {
				b[i]=(byte) socket.getInputStream().read();
			}
			fileOutputStream.write(b);
			fileOutputStream.flush();
			
		} catch (Exception e) {
			throw e;
		}
	}


}
