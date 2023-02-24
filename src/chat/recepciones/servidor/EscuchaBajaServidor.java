package chat.recepciones.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioRegistroServidor;
import chat.recepciones.Servidor;

public class EscuchaBajaServidor extends Servidor {

	public EscuchaBajaServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String ip=socket.getInetAddress().getHostAddress();
		Servidor.usuarios.remove(ip);
		for (String ip1 : Servidor.usuarios.keySet()) {
			
			EnvioRegistroServidor envioRegistroServidor= new EnvioRegistroServidor(ip1, Cliente.PUERTO_ESCUCHA_REGISTRO_CLIENTE, getChat());
			envioRegistroServidor.start();
			
		}

	}

}
