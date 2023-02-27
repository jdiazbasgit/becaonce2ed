package chat.envios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import chat.ChatGridBag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cliente extends Thread {

	public static final int PUERTO_ENVIO_REGISTRO_SERVIDOR = 5000;
	public static final int PUERTO_ENVIO_MENSAJE_SERVIDOR = 5002;
	public static final int PUERTO_ESCUCHA_REGISTRO_CLIENTE=5001;
	public static final int PUERTO_ESCUCHA_MENSAJE_CLIENTE = 5003;
	public static final int PUERTO_ENVIO_BAJA_CLIENTE=5004;
	public static final String IP_SERVIDOR = "192.168.10.71";
	
	// public static int PUERTO_ENVIO_MENSAJE_CLIENTE = 5002;
	// public static int PUERTO_ENVIO_ARCHIVO = 5003;
	// public static int PUERTO_ENVIO_PRIVADO = 5004;
	public static Map<String, String> usuarios= new HashMap<>();

	private String ip;
	private int puerto;
	private ChatGridBag chat;

	@Override
	public void run() {

		Socket socket = null;
		try {
			socket = new Socket(getIp(), getPuerto());
			hacerAlgo(socket);
			System.out.println("Hacer algo::: "+socket);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void hacerAlgo(Socket socket);

	public void enviarTexto(Socket socket, String texto) throws Exception {
		try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
			printWriter.println(texto);
			printWriter.flush();
		} catch (Exception e) {
			throw e;
		}

	}

	public void enviarObjeto(Socket socket, Object object) throws Exception {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
		} catch (Exception e) {
			throw e;
		}
	}

	public void enviarArchivo(Socket socket, String ruta) throws Exception {
		try (FileInputStream fileInputStream = new FileInputStream(ruta)) {
			byte[] b = new byte[fileInputStream.available()];
			for (int i = 0; i < b.length; i++) {
				socket.getOutputStream().write(b[i]);
				socket.getOutputStream().flush();
			}
		} catch (Exception e) {
			throw e;
		}

	}

}
