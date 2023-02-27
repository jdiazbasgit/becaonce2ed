package chat.recepciones.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioRegistroServidor;
import chat.recepciones.Servidor;

public class EscuchaRegistroServidor extends Servidor {

	public EscuchaRegistroServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
		
	}

	@Override
	public void hacerAlgo(Socket socket) {
		try {
			String nick=leerMensaje(socket);
			String ip= socket.getInetAddress().getHostAddress();
			Servidor.usuarios.put(ip, nick);
			
			for (String destino : Servidor.usuarios.keySet()) {
				EnvioRegistroServidor envioRegistroServidor= new EnvioRegistroServidor(destino, Cliente.PUERTO_ESCUCHA_REGISTRO_CLIENTE, getChat());
				envioRegistroServidor.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
