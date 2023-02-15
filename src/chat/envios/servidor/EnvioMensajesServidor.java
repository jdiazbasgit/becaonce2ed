package chat.envios.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.recepciones.Servidor;

public class EnvioMensajesServidor extends Cliente {

	public EnvioMensajesServidor(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
		
	}

	public void hacerAlgo(Socket socket) {

		try {
			enviarObjeto(socket, Servidor.usuarios);
		} catch (Exception e) {
			
			e.printStackTrace();
		}


	}

}
